package com.netzign.async.service.impl;

import java.util.concurrent.Future;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import com.netzign.async.service.DummyTwoService;

@Service
public class DummyTwoServiceImpl implements DummyTwoService {

	@Override
	@Async
	public Future<String> process() {

		try {
			System.out.println("dummy service two impl is sleeping");
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("DummyTwo Service is done!");

		return new AsyncResult<String>("DummyTwo is Done");
	}

}
