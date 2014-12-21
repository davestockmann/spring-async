package com.netzign.async.service.impl;

import java.util.concurrent.Future;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import com.netzign.async.service.DummyService;

@Service
public class DummyServiceImpl implements DummyService {

	@Override
	@Async
	public Future<String> process() {
		try {
			System.out.println("dummy service impl is sleeping");
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Dummy Service is done!");

		return new AsyncResult<String>("Dummy is Done");
	}

}
