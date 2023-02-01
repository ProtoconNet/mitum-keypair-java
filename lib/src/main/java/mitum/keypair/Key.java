package mitum.keypair;

class Key {
    static final int MIN_LEN = 46;
    static final int SUFFIX_LEN = 3;
    private String k;
    private String suffix;

    protected Key(String s) {
        if (s.length() < MIN_LEN) {
            throw new IndexOutOfBoundsException("invalid length of key");
        }

        this.k = s.substring(0, s.length() - SUFFIX_LEN);
        this.suffix = s.substring(s.length() - SUFFIX_LEN);
    }

    public String getKey() {
        return k;
    }

    public byte[] toByteArray() {
        return this.toString().getBytes();
    }

    public String toString() {
        return this.k + this.suffix;
    }
}
