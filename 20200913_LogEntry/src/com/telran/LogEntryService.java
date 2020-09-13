package com.telran;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LogEntryService {

    public Map<String, Long> getEntriesAmount(List<LogEntry> logEntries) {
        return logEntries.stream()
                .collect(Collectors.groupingBy(LogEntry::getUrl,
                        Collectors.counting()));
    }

    public Map<String, List<LogEntry>> getUniqueUsersByUrl(List<LogEntry> logEntries) {
        return logEntries.stream()
                .collect(Collectors.groupingBy(LogEntry::getUrl));
    }

    public Map<String, List<LogEntry>> getUniqueUrlsByUser(List<LogEntry> logEntries) {
        return logEntries.stream()
                .collect(Collectors.groupingBy(LogEntry::getUsername));
    }

}
