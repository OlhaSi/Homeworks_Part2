package com.telran;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import sun.rmi.runtime.Log;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class CustomCollectorLogEntry implements Collector<LogEntry, List<LogEntry>, Integer> {

    @Override
    public Supplier<List<LogEntry>> supplier() {
        return ArrayList::new;
    }

    @Override
    public BiConsumer<List<LogEntry>, LogEntry> accumulator() {
        return List::add;
    }

    @Override
    public BinaryOperator<List<LogEntry>> combiner() {
        return (list1, list2) -> {
            list1.addAll(list2);
            return list1;
        };
    }

    @Override
    public Function<List<LogEntry>, Integer> finisher() {
        return logEntries -> (int) logEntries.stream()
                .map(LogEntry::getUsername)
                .distinct()
                .count();
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Collections.emptySet();
    }
}
