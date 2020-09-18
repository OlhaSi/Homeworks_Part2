package com.telran;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class LogEntryService {

    public Map<String, Long> getEntriesAmount(List<LogEntry> logEntries) {
        return logEntries.stream()
                .collect(groupingBy(LogEntry::getUrl,
                        counting()));
    }

    // my version
//    public Map<String, List<LogEntry>> getUniqueUsersByUrl(List<LogEntry> logEntries) {
//        return logEntries.stream()
//                .collect(groupingBy(LogEntry::getUrl));
//    }

    // how it should be
    public Map<String, Integer> getUniqueUsersNumberByUrl(List<LogEntry> logEntries) {
        return logEntries.stream()
                .collect(groupingBy(LogEntry::getUrl,
                        mapping(LogEntry::getUsername,
                                collectingAndThen(toSet(), Set::size))));
    }

    // realisation using custom collector
    public Map<String, Integer> getUniqueUsersNumberByUrlCustomCollector(List<LogEntry> logEntries) {
        return logEntries.stream()
                .collect(groupingBy(LogEntry::getUrl, new CustomCollectorLogEntry()));
    }

    // my version
//    public Map<String, List<LogEntry>> getUniqueUrlsByUser(List<LogEntry> logEntries) {
//        return logEntries.stream()
//                .collect(groupingBy(LogEntry::getUrl));
//    }

    // how it should be
    public Map<String, Integer> getUniqueUrlNumberByUser(List<LogEntry> logEntries) {
        return logEntries.stream()
                .collect(groupingBy(LogEntry::getUsername,
                        mapping(LogEntry::getUrl,
                                collectingAndThen(toSet(), Set::size))));
    }

    // general collector
    public Map<String, Integer> getUniqueUsersNumberByUrlDistinct(List<LogEntry> logs) {

        Function<LogEntry, String> getUsername = LogEntry::getUsername;
        DistinctCountingBy<LogEntry, String> countingBy = new DistinctCountingBy<>(getUsername);

        return logs.stream()
                .collect(groupingBy(LogEntry::getUrl, countingBy
                ));
    }
}
