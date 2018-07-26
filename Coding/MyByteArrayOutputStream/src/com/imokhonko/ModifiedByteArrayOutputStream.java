package com.imokhonko;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ModifiedByteArrayOutputStream extends OutputStream {

    private static final int DEFAULT_SIZE = 16;
    private List<byte[]> bufferList = new ArrayList<>();
    private static final AllocateStrategy DEFAULT_ALLOCATE_STRATEGY = new AllocateStrategy ();
    private final AllocateStrategy strategy;

    private int count = 0;

    public ModifiedByteArrayOutputStream() {
        this(DEFAULT_SIZE, DEFAULT_ALLOCATE_STRATEGY);
    }

    public ModifiedByteArrayOutputStream(int startSize) {
        this(startSize, DEFAULT_ALLOCATE_STRATEGY);
    }

    public ModifiedByteArrayOutputStream(AllocateStrategy strategy) {
        this(DEFAULT_SIZE, strategy);
    }

    public ModifiedByteArrayOutputStream(int startSize, AllocateStrategy strategy) {
        bufferList.add (new byte[startSize]);
        this.strategy = strategy;
    }

    @Override
    public void write(int b) throws IOException {
        // get the last buff array from bufferList
        byte[] lastBuff = bufferList.get (bufferList.size () - 1);

        // if current position is equals to buffer length make new byte array
        // using our strategy and add it to bufferList
        // then make count = 0
        // and change the link to last buffer
        if(count == lastBuff.length) {
            int newSize = strategy.nextValue (lastBuff.length);
            byte[] newLastBuff = new byte[newSize];
            bufferList.add (newLastBuff);
            count = 0;
            lastBuff = newLastBuff;
        }

        // write one byte to last buffer in bufferList
        lastBuff[count++] = (byte) b;
    }

    @Override
    public void write(byte[] b) throws IOException {
        byte[] lastBuff = bufferList.get (bufferList.size () - 1);

        // checking if the count of cells in lastBuff is smaller then write all free cell in current array and create new array
        // in new array we write other bytes from b
        if((lastBuff.length - count) < b.length) {
            int freeBytes = (lastBuff.length - count);
            System.arraycopy (b, 0, lastBuff, count, freeBytes);

            int restBytes = b.length - freeBytes;
            int newSize = strategy.nextValue(restBytes);
            byte[] newLastBuff = new byte[newSize];
            bufferList.add (newLastBuff);
            count = 0;
            lastBuff = newLastBuff;

            System.arraycopy (b, freeBytes, lastBuff, 0, (b.length - freeBytes));
            count = (b.length - freeBytes);
            return;
        }
        System.arraycopy (b, 0, lastBuff, count, b.length);
        count += b.length;
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        //super.write(b, off, len);
    }

    public void writeTo(OutputStream out) throws IOException {
        for (int i = 0; i < bufferList.size () - 1; i++) {
            byte[] buff = bufferList.get (i);
            out.write (buff);
        }

        byte[] buff = bufferList.get (bufferList.size () - 1);
        // write using count
        // because the last buff array can be not full
        out.write (buff, 0, count);
    }

    public byte[] toByteArray() {

        // total size of byte array that will be returned
        int totalSize = 0;

        // iterating through bufferList byte arrays excluding last array in list
        // incrementing total size of each array
        for (int i = 0; i < bufferList.size () - 1; i++) {
            totalSize += bufferList.get (i).length;
        }
        // increment totalSize by last array
        totalSize += count;

        // current index for last ellement in result array
        int index = 0;

        // creating result array with totalSize length
        byte[] result = new byte[totalSize];

        // iterating through every byte array (excluding last) in bufferList and copy them into result array
        for (int i = 0; i < bufferList.size () - 1; i++) {
            byte[] buff = bufferList.get (i);
            System.arraycopy (buff, 0, result, index, buff.length);
            index += buff.length;
        }

        // copy last array from list
        byte[] buff = bufferList.get (bufferList.size () - 1);
        System.arraycopy (buff, 0, result, index, count);

        return result;
    }

    public void getBufferListLength() {
        for (byte[] bytes : bufferList) {
            System.out.println("array length: " + bytes.length + " | " + Arrays.toString(bytes));
        }
    }

}
