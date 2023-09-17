package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.protocol.exceptions.TransactionException;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.Contract;
import org.web3j.tx.Transfer;
import org.web3j.tx.gas.DefaultGasProvider;
import org.web3j.utils.Convert;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.concurrent.ExecutionException;

@SpringBootTest
class DemoApplicationTests {

	String url = "https://mumbai.polygonscan.com/address/0x0314502e8f38be59221b95c60eefeb39fe3b5a78";
	String rpc  = "https://rpc-mumbai.maticvigil.com";

	@Test
	void contextLoads() {
	}

	@Test
	void web3j() throws Exception {

//		String rpc  = "https://polygon-testnet.public.blastapi.io";
		Web3j web3j = Web3j.build(new HttpService(rpc));
		Credentials credentials = Credentials.create("1a4ff3526156645c98905b94d876d1affd9f28685387c028369b5a1fe4b3bdc2");

		Abi abi = Abi.load("0x0314502e8f38be59221b95c60eefeb39fe3b5a78",
				web3j, credentials, new DefaultGasProvider());

		RemoteFunctionCall<String> result = abi.tokenURI(BigInteger.ZERO);

//		Abi.deployRemoteCall(web3j, credentials, )

		System.out.println(result.send());
	}

	@Test
	void connn() throws Exception {
		Web3j web3j = Web3j.build(new HttpService(rpc));
		System.out.println(web3j.web3ClientVersion().send().getWeb3ClientVersion());

		//
		Credentials credentials = Credentials.create("1a4ff3526156645c98905b94d876d1affd9f28685387c028369b5a1fe4b3bdc2");


//		System.out.println(transfer.getTransactionHash());
	}

	@Test
	void zeroT() throws IOException {
		String url = "https://mumbai.polygonscan.com";
		Web3j web3j = Web3j.build(new HttpService(url));
		System.out.println(web3j.web3ClientVersion().send().getWeb3ClientVersion());
	}


}
