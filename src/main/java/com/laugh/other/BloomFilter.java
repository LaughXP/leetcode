package com.laugh.other;

import java.util.Objects;

/**
 * @author yu.gao 2020-01-16 3:43 PM
 */
public class BloomFilter {
    private int k;
    private int bitsPerKey;
    private int bitLen;
    private byte[] result;
    public BloomFilter(int k,int bitsPerKey){
        this.k = k;
        this.bitsPerKey = bitsPerKey;
    }
    public byte[] generate(byte[][] keys){
        assert keys != null;
        bitLen = keys.length * bitsPerKey;
        bitLen = (( bitLen + 7 ) / 8) << 3;//align the bitLen.
        bitLen = bitLen < 64 ? 64 : bitLen;
        result = new byte[ bitLen >> 3]; //eachbyte have 8 bit.
        for( int i = 0; i < keys.length; i++){
            assert keys[i] != null;
            int h = Objects.hash(keys[i]); // Bytes.hash()
            for( int t = 0; t < k; t++) {
                int idx = ( h % bitLen + bitLen ) % bitLen;
                result[ idx / 8] |= ( 1 << ( idx % 8 ));
                int delta= ( h >> 17 ) | ( h << 15 );
                h += delta;
            }
        }
        return result;
    }
    public boolean contains(byte[]key){
        assert result != null;
        int h = Objects.hash(key); // Bytes.hash()
        for(int t=0; t<k; t++){//Hash k times
            int idx = ( h % bitLen + bitLen ) % bitLen;
            if(( result[idx / 8] & (1 << (idx % 8)))==0){
                return false;}
                int delta = ( h >> 17) | ( h << 15);
                h += delta;}
                return true;
    }
}