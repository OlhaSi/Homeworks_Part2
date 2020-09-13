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
        List<LogEntry> logEntries = Arrays.asList(new LogEntry("Dan", "punkt.com"),
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
        List<LogEntry> logEntries = Arrays.asList(new LogEntry("Dan", "punkt.com"),
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
        Map<String, List<LogEntry>> expected = Collections.emptyMap();

        assertEquals(expected, logEntryService.getUniqueUsersByUrl(logEntries));
    }

    @Test
    public void testGetUniqueUsersByUrl_1() {
        LogEntry l1 = new LogEntry("Dan", "punkt.com");
        List<LogEntry> logEntries = Collections.singletonList(l1);

        Map<String, List<LogEntry>> expected = new HashMap<>();
        expected.put("punkt.com", logEntries);

        assertEquals(expected, logEntryService.getUniqueUsersByUrl(logEntries));
    }

    @Test
    public void testGetUniqueUsersByUrl_2() {
        LogEntry l1 = new LogEntry("Dan", "punkt.com");
        LogEntry l2 = new LogEntry("Daniel", "punkt.com");
        List<LogEntry> logEntries = Arrays.asList(l1, l2);

        Map<String, List<LogEntry>> expected = new HashMap<>();
        expected.put("punkt.com", logEntries);

        assertEquals(expected, logEntryService.getUniqueUsersByUrl(logEntries));
    }

    @Test
    public void testGetUniqueUsersByUrl_3() {
        LogEntry l1 = new LogEntry("Dan", "punkt.com");
        LogEntry l2 = new LogEntry("Daniel", "punkt.com");
        LogEntry l3 = new LogEntry("Kate", "com.com");
        LogEntry l4 = new LogEntry("Mary", "u.ua");
        List<LogEntry> logEntries = Arrays.asList(l1, l2, l3, l4);

        Map<String, List<LogEntry>> expected = new HashMap<>();
        List<LogEntry> list1 = Arrays.asList(l1, l2);
        List<LogEntry> list2 = Collections.singletonList(l3);
        List<LogEntry> list3 = Collections.singletonList(l4);

        expected.put("punkt.com", list1);
        expected.put("com.com", list2);
        expected.put("u.ua", list3);

        assertEquals(expected, logEntryService.getUniqueUsersByUrl(logEntries));
    }

    @Test
    public void testGetUniqueUrlsByUser_zero() {
        List<LogEntry> logEntries = Collections.emptyList();
        Map<String, List<LogEntry>> expected = Collections.emptyMap();

        assertEquals(expected, logEntryService.getUniqueUrlsByUser(logEntries));
    }

    @Test
    public void testGetUniqueUrlsByUser_1() {
        LogEntry l1 = new LogEntry("Dan", "punkt.com");
        List<LogEntry> logEntries = Collections.singletonList(l1);

        Map<String, List<LogEntry>> expected = new HashMap<>();
        expected.put("Dan", logEntries);

        assertEquals(expected, logEntryService.getUniqueUrlsByUser(logEntries));
    }

    @Test
    public void testGetUniqueUrlsByUser_2() {
        LogEntry l1 = new LogEntry("Dan", "punkt.com");
        LogEntry l2 = new LogEntry("Dan", "punkt1.com");
        List<LogEntry> logEntries = Arrays.asList(l1, l2);

        Map<String, List<LogEntry>> expected = new HashMap<>();
        expected.put("Dan", logEntries);

        assertEquals(expected, logEntryService.getUniqueUrlsByUser(logEntries));
    }

    @Test
    public void testGetUniqueUrlsByUser_3() {
        LogEntry l1 = new LogEntry("Dan", "punkt.com");
        LogEntry l2 = new LogEntry("Dan", "punkt1.com");
        LogEntry l3 = new LogEntry("Kate", "com.com");
        LogEntry l4 = new LogEntry("Mary", "u.ua");
        List<LogEntry> logEntries = Arrays.asList(l1, l2, l3, l4);

        Map<String, List<LogEntry>> expected = new HashMap<>();
        List<LogEntry> list1 = Arrays.asList(l1, l2);
        List<LogEntry> list2 = Collections.singletonList(l3);
        List<LogEntry> list3 = Collections.singletonList(l4);

        expected.put("Dan", list1);
        expected.put("Kate", list2);
        expected.put("Mary", list3);

        assertEquals(expected, logEntryService.getUniqueUrlsByUser(logEntries));
    }
}