package com.telran;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class LogEntryServiceTest {

    LogEntryService logEntryService;

    @BeforeEach
    void init() {
        logEntryService = new LogEntryService();
    }

    @Test
    public void testGetEntriesAmount_zero() {
        List<LogEntry> logEntries = Collections.emptyList();
        Map<String, Long> expected = Collections.emptyMap();

        assertEquals(expected, logEntryService.getEntriesAmount(logEntries));
    }

    @Test
    public void testGetEntriesAmount_1() {
        List<LogEntry> logEntries = Arrays.asList(
                new LogEntry("Dan", "punkt.com"),
                new LogEntry("Kate", "com.com"),
                new LogEntry("Mary", "u.ua"));
        Map<String, Long> expected = new HashMap<>();
        expected.put("punkt.com", 1L);
        expected.put("com.com", 1L);
        expected.put("u.ua", 1L);

        assertEquals(expected, logEntryService.getEntriesAmount(logEntries));
    }

    @Test
    public void testGetEntriesAmount_2() {
        List<LogEntry> logEntries = Arrays.asList(
                new LogEntry("Dan", "punkt.com"),
                new LogEntry("Kate", "com.com"),
                new LogEntry("Mary", "u.ua"),
                new LogEntry("Jane", "u.ua"));
        Map<String, Long> expected = new HashMap<>();
        expected.put("punkt.com", 1L);
        expected.put("com.com", 1L);
        expected.put("u.ua", 2L);

        assertEquals(expected, logEntryService.getEntriesAmount(logEntries));
    }

    @Test
    public void testGetUniqueUsersByUrl_zero() {
        List<LogEntry> logEntries = Collections.emptyList();
        Map<String, Integer> expected = Collections.emptyMap();

        assertEquals(expected, logEntryService.getUniqueUsersNumberByUrl(logEntries));
    }

    @Test
    public void testGetUniqueUsersByUrl_1() {
        LogEntry l1 = new LogEntry("Dan", "punkt.com");
        List<LogEntry> logEntries = Collections.singletonList(l1);

        Map<String, Integer> expected = new HashMap<>();
        expected.put("punkt.com", 1);

        assertEquals(expected, logEntryService.getUniqueUsersNumberByUrl(logEntries));
    }

    @Test
    public void testGetUniqueUsersByUrl_2() {
        LogEntry l1 = new LogEntry("Dan", "punkt.com");
        LogEntry l2 = new LogEntry("Daniel", "punkt.com");
        List<LogEntry> logEntries = Arrays.asList(l1, l2);

        Map<String, Integer> expected = new HashMap<>();
        expected.put("punkt.com", 2);

        assertEquals(expected, logEntryService.getUniqueUsersNumberByUrl(logEntries));
    }

    @Test
    public void testGetUniqueUsersByUrl_3() {
        LogEntry l1 = new LogEntry("Dan", "punkt.com");
        LogEntry l2 = new LogEntry("Daniel", "punkt.com");
        LogEntry l3 = new LogEntry("Kate", "com.com");
        LogEntry l4 = new LogEntry("Mary", "u.ua");
        List<LogEntry> logEntries = Arrays.asList(l1, l2, l3, l4);

        Map<String, Integer> expected = new HashMap<>();
        expected.put("punkt.com", 2);
        expected.put("com.com", 1);
        expected.put("u.ua", 1);

        assertEquals(expected, logEntryService.getUniqueUsersNumberByUrl(logEntries));
    }

    @Test
    public void testGetUniqueUrlsByUser_zero() {
        List<LogEntry> logEntries = Collections.emptyList();
        Map<String, Integer> expected = Collections.emptyMap();

        assertEquals(expected, logEntryService.getUniqueUrlNumberByUser(logEntries));
    }

    @Test
    public void testGetUniqueUrlsByUser_1() {
        LogEntry l1 = new LogEntry("Dan", "punkt.com");
        List<LogEntry> logEntries = Collections.singletonList(l1);

        Map<String, Integer> expected = new HashMap<>();
        expected.put("Dan", 1);

        assertEquals(expected, logEntryService.getUniqueUrlNumberByUser(logEntries));
    }

    @Test
    public void testGetUniqueUrlsByUser_2() {
        LogEntry l1 = new LogEntry("Dan", "punkt.com");
        LogEntry l2 = new LogEntry("Dan", "punkt1.com");
        List<LogEntry> logEntries = Arrays.asList(l1, l2);

        Map<String, Integer> expected = new HashMap<>();
        expected.put("Dan", 2);

        assertEquals(expected, logEntryService.getUniqueUrlNumberByUser(logEntries));
    }

    @Test
    public void testGetUniqueUrlsByUser_3() {
        LogEntry l1 = new LogEntry("Dan", "punkt.com");
        LogEntry l2 = new LogEntry("Dan", "punkt1.com");
        LogEntry l3 = new LogEntry("Kate", "com.com");
        LogEntry l4 = new LogEntry("Mary", "u.ua");
        List<LogEntry> logEntries = Arrays.asList(l1, l2, l3, l4);

        Map<String, Integer> expected = new HashMap<>();
        expected.put("Dan", 2);
        expected.put("Kate", 1);
        expected.put("Mary", 1);

        assertEquals(expected, logEntryService.getUniqueUrlNumberByUser(logEntries));
    }

    @Test
    public void testGetUniqueUsersByUrlCustomCollector_zero() {
        List<LogEntry> logEntries = Collections.emptyList();
        Map<String, Integer> expected = Collections.emptyMap();

        assertEquals(expected, logEntryService.getUniqueUsersNumberByUrlCustomCollector(logEntries));
    }

    @Test
    public void testGetUniqueUsersByUrlCustomCollector_1() {
        LogEntry l1 = new LogEntry("Dan", "punkt.com");
        List<LogEntry> logEntries = Collections.singletonList(l1);

        Map<String, Integer> expected = new HashMap<>();
        expected.put("punkt.com", 1);

        assertEquals(expected, logEntryService.getUniqueUsersNumberByUrlCustomCollector(logEntries));
    }

    @Test
    public void testGetUniqueUsersByUrlCustomCollector_2() {
        LogEntry l1 = new LogEntry("Dan", "punkt.com");
        LogEntry l2 = new LogEntry("Daniel", "punkt.com");
        List<LogEntry> logEntries = Arrays.asList(l1, l2);

        Map<String, Integer> expected = new HashMap<>();
        expected.put("punkt.com", 2);

        assertEquals(expected, logEntryService.getUniqueUsersNumberByUrlCustomCollector(logEntries));
    }

    @Test
    public void testGetUniqueUsersByUrlCustomCollector_3() {
        LogEntry l1 = new LogEntry("Dan", "punkt.com");
        LogEntry l2 = new LogEntry("Daniel", "punkt.com");
        LogEntry l3 = new LogEntry("Kate", "com.com");
        LogEntry l4 = new LogEntry("Mary", "u.ua");
        List<LogEntry> logEntries = Arrays.asList(l1, l2, l3, l4);

        Map<String, Integer> expected = new HashMap<>();
        expected.put("punkt.com", 2);
        expected.put("com.com", 1);
        expected.put("u.ua", 1);

        assertEquals(expected, logEntryService.getUniqueUsersNumberByUrlCustomCollector(logEntries));
    }
}