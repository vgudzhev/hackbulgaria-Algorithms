package com.vgudzhev.tree_lecture.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.vgudzhev.tree_lecture.bandwidthManager.BandwidthManager;

public class BandwidthManagerTests {
/**
rcv UDP zxchzrkljhklzrjlkhklzr
rcv TCP ghljkajklhgjklare
rcv ICMP ping87.129.54.123
send
\>ping87.129.54.123
send
\>zxchzrkljhklzrjlkhklzr
rcv DNS maps.google.com
send
\>maps.google.com
rcv TCP aejkgjkaegaegae
send
\>ghljkajklhgjklare
send
\>aejkgjkaegaegae
send
\>Nothing to send!
 */
	@Test
	public void test() {
		BandwidthManager manager = new BandwidthManager();
		manager.rcv("UDP", "zxchzrkljhklzrjlkhklzr");
		manager.rcv("TCP", "ghljkajklhgjklare");
		manager.rcv("ICMP", "ping87.129.54.123");
		
		assertEquals(manager.send(), "ping87.129.54.123");
		assertEquals(manager.send(), "zxchzrkljhklzrjlkhklzr");
		
		manager.rcv("DNS", "maps.google.com");
		assertEquals(manager.send(), "maps.google.com");
		
		manager.rcv("TCP", "aejkgjkaegaegae");
		assertEquals(manager.send(), "aejkgjkaegaegae");
		assertEquals(manager.send(), "aejkgjkaegaegae");
		assertEquals(manager.send(), "Nothing to send!");
		
	
	}

}
