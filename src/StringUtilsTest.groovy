import junit.framework.TestCase

class StringUtilsTest extends TestCase {
    private final Map toHexStringData = new HashMap();
    protected void setUp() throws Exception {
        super.setUp()
        toHexStringData.put("", new byte[0]);
    }
    protected void tearDown() throws Exception {
        toHexStringData.clear();
    }

    public void testIsEmpty() {
        boolean actual = StringUtils.isEmpty(null);
        assertTrue(actual);
        actual = StringUtils.isEmpty("");
        assertTrue(actual);
        actual = StringUtils.isEmpty(" ");
        assertFalse(actual);
        actual = StringUtils.isEmpty("some string");
        assertFalse(actual);
    }

    public void testToHexString() {
        for (Iterator iterator = toHexStringData.keySet().iterator(); iterator.hasNext();)
        {
            final String expected = (String) iterator.next();
            final byte[] testData = (byte[]) toHexStringData.get(expected);
            final String actual = StringUtils.toHexString(testData);
            assertEquals(expected, actual);
        }
    }

}
