import org.junit.*
import org.junit.rules.ExpectedException
import org.junit.rules.TemporaryFolder
import org.junit.rules.Timeout

class StringUtilsTestJUnit4 extends Assert {
    private static Map<String, byte[]> toHexStringData = new HashMap<String, byte[]>();

    @Before
    public void setUpToHexStringData() {
        toHexStringData.put("", new byte[0]);
        toHexStringData.put("01020d112d7f", [1, 2, 13, 17, 45, 127]);
        toHexStringData.put("00fff21180", [0, -1, -14, 17, -128]);
    }

    @After
    public void tearDown() throws Exception {
        toHexStringData.clear();
    }

    @Test
    public void testToHexString() {
        for (Map.Entry<String, byte[]> entry : toHexStringData.entrySet()) {
            final byte[] testData = entry.getValue();
            final String expected = entry.getKey();
            final String actual = StringUtils.toHexString(testData);
            assertEquals(expected, actual);
        }
    }

    @Rule
    public final TemporaryFolder folder = new TemporaryFolder();
    @Rule
    public final Timeout timeout = new Timeout(1000);
    @Rule
    public final ExpectedException thrown = ExpectedException.none();

    @Ignore
    @Test
    public void anotherInfinity() {
        while (true);
    }

    @Test
    public void testFileWriting() throws IOException {
        final File log = folder.newFile("debug.log");
        final FileWriter logWriter = new FileWriter(log);
        logWriter.append("Hello, ");
        logWriter.append("World!!!");
        logWriter.flush();
        logWriter.close();

    }
}