package com.vgudzhev.tree_lecture.bandwidthManager;

import com.vgudzhev.tree_lecture.ds.GenericMaxHeap;

public class BandwidthManager {

	private GenericMaxHeap<BandwidthManagerPair> heap = new GenericMaxHeap<BandwidthManagerPair>();

	// receives a packet with specified protocol and payload
	public void rcv(String protocol, String payload) {
		heap.insert(BandwidthManagerPair.getInstance(protocol, payload));
	}

	// returns the payload of the packet which should be sent
	public String send() {
		BandwidthManagerPair pair = heap.popMax();
		return pair == null ? pair.payload: "Nothing to send!";
	}
}