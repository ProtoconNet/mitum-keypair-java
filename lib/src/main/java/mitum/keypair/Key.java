package mitum.keypair;

import mitum.keypair.exception.InvalidLengthArgumentException;

class Key {
    static final int MIN_LEN = 46;
    static final int SUFFIX_LEN = 3;
    private String k;
    private String suffix;

    protected Key(String s) {
        if (s.length() < MIN_LEN) {
            throw new InvalidLengthArgumentException("invalid length of key");
        }

        this.k = s.substring(0, s.length() - SUFFIX_LEN);
        this.suffix = s.substring(s.length() - SUFFIX_LEN);
    }

    public String getKey() {
        return k;
    }

    public String toString() {
        return this.k + this.suffix;
    }
}
