package com.netzign.async.service.impl;

import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netzign.async.service.DummyService;
import com.netzign.async.service.DummyTwoService;
import com.netzign.async.service.SplitterService;

@Service
public class SplitterServiceImpl implements SplitterService {

	@Autowired
	private DummyService dummy;

	@Autowired
	private DummyTwoService dummy2;

	@Override
	public void process() {

		try {
			Future<String> dummyResult = dummy.process();
			Future<String> dummy2Result = dummy2.process();

			while (!dummyResult.isDone() && !dummy2Result.isDone()) {
				System.out.print("checking to see if both are done...");
				System.out.print(" dummy is done: " + dummyResult.isDone());
				System.out.print(" dummy2 is done: " + dummy2Result.isDone()
						+ "\r\n");
			}

			System.out.println("dummyResult is: " + dummyResult.get());
			System.out.println("dummyResult is: " + dummy2Result.get());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

}
