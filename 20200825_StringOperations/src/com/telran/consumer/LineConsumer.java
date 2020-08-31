package com.telran.consumer;

import java.io.PrintWriter;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

public class LineConsumer extends Thread {

    public static final String STOP_COMMAND = "stop_word";
    static final String DELIMITER = "#";
    static final String WRONG_LINE = "Wrong line";
    static final String WRONG_OPERATION = "Operation not found";
    final BlockingQueue<String> queue;
    final OperationStorage operationStorage;
    final PrintWriter pw;
    //final AtomicBoolean isAlive;

    public LineConsumer(BlockingQueue<String> queue,
                        OperationStorage operationStorage,
                        PrintWriter pw) {
        this.queue = queue;
        this.operationStorage = operationStorage;
        this.pw = pw;
        //this.isAlive = isAlive;
    }

    @Override
    public void run() {
        try {
            while (true) {
                String line = queue.take();
//                synchronized (isAlive) {
//                    if (!isAlive.get() && queue.isEmpty())
//                        return;
//                    line = queue.take();
//                }

                if (line.equals(STOP_COMMAND))
                    return;
                // split the line on parts: the text to operate on and the name of the operation

                String res = processLine(line);

                pw.println(res);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Accept line and transforms it to another line. Line should contain
     * two parts separated by {@code DELIMITER}. The first part is the text to
     * operate on. The second part is the name of the operation to operate.
     * @param line a string in the right format
     * @return transformed text according to the operation, if the line is
     * correct or satisfies to the requirements.
     * If the amount of parts in the line is not equal to two,
     * then "'line'#Wrong line" should return.
     * If the operation not found, then "'line'#Operation not supported"
     * should return.
     */
    String processLine (String line){
        String[] splitLine = line.split(DELIMITER);
        if (splitLine.length != 2){
            return line + "#" + WRONG_LINE;
        }
        String text = splitLine[0];
        String operationName = splitLine[1];

        StringOperation operation = operationStorage.getByName(operationName);

        if (operation == null){
            return line + "#" + WRONG_OPERATION;
        }

        return operation.operate(text);
    }
}
