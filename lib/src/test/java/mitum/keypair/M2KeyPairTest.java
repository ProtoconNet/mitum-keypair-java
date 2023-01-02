package mitum.keypair;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.bitcoinj.core.Base58;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class M2KeyPairTest {
	@DisplayName("m2; random; val")
	@Test
	void randomNotThrowsException() {
		for (int i = 0; i < 1000; i++) {
			assertDoesNotThrow(() -> {
				M2KeyPair kp = M2KeyPair.random();
				kp.sign("mitum");
			});
		}
	}

	@DisplayName("m2; from private key; val")
	@Test
	void fromPrivateKeyReturnsValidKeyPair() {
		for (int i = 0; i < 1000; i++) {
			M2KeyPair kp1 = M2KeyPair.random();
			M2KeyPair kp2 = M2KeyPair.from(kp1.getPrivateKey());
			M2KeyPair kp3 = M2KeyPair.from(kp1.getPrivateKey().toString());

			assertEquals(kp1.getPrivateKey().toString(), kp2.getPrivateKey().toString());
			assertEquals(kp1.getPrivateKey().toString(), kp3.getPrivateKey().toString());
			assertEquals(kp1.getPublicKey().toString(), kp2.getPublicKey().toString());
			assertEquals(kp1.getPublicKey().toString(), kp3.getPublicKey().toString());
		}
	}

	@DisplayName("m2; from private key; mitum")
	@Test
	void fromPrivateKeyReturnsSameKeyPairWithMitum() {
		String[][] tcs = {
				{ "F1wL8DkcP4mjCUWB9kRbzRZos4HPVy4Fb5XMQ1zWwnxhmpr",
						"kYRSLypSeVoaAAGs4ZRbbrePsSmqSjW9S7b86ub7ZXjRmpu" },
				{ "HW9jquPB5ZEoAxJcXrd6w5dEdqtuhHSwDzSAxeiBnUKympr",
						"2AnXJKJn1QrHKKzDpGJgsFstAXZRFUNYDEjejLQUqf6e5mpu" },
				{ "56nUSEAnihm6DiiMJqbFtpTUdc24z1tShCWUhvSgGNpempr",
						"2AwFiHcyethi5pexuh1HB7PF3a1yMuYpu45HmTnjbPTbgmpu" },
				{ "CQvfFr8jtxJUtkcjcXVz7QDaoSXhUMVaXwLpBPRSZPt1mpr",
						"22vEGZJHZecxzQ8AFYx7obSLWkpugzjJ6prw7VPw8S57Smpu" },
				{ "4rR4FbwjxheLCTybmeLtbZCtuLkKqFXzLmFhUYAgNLFimpr",
						"21N7nVN8jyZFzDuU71FAxGAgfaG2Cr3drL8Ndi2yyVxjGmpu" },
				{ "8EJNUp3Hmtrcp4scMSbAqPNMPdw7Za3mSWtSRTLnbcrqmpr",
						"29DQDJtgBF1GLEzvrS9p6H6YCHUGvwECV5D9WqzkjaUKMmpu" },
				{ "GEmtmRYVQSDGGYmfJC6MmVnrACcvShAXbYEQGGt9iK6mpr",
						"u3Ub1mtsPNNK1NrcPf3NrWkQMVRkDBU8N84tVNKeN6SKmpu" },
				{ "3BrSzE7g3MZpwSJ684C75zNnv6Nip1eiA15vycVJrTMnmpr",
						"24iJWUXeM1DGQkLCyTDpwGfCe1QRMHz4P2ocKbAxAbE4Tmpu" },
				{ "KHihLt6HhrKveLCkrZo1a9AxMcPN7GTsVjJaA6411WKmpr",
						"27qzennnDjYig5UeJEoayCPHX9MooCRhfqjvRExQ2VZ7Pmpu" },
				{ "DYVgtVqpoRdeCks6yMRuAh8MfTK32xF7LWBToHUx9LTEmpr",
						"iHnJRfpsoQwH8qNt7JvQkdv5bG3otYquMaT1bSu85Q2Jmpu" },
		};

		for (String[] tc : tcs) {
			M2KeyPair kp = M2KeyPair.from(tc[0]);
			assertEquals(tc[0], kp.getPrivateKey().toString());
			assertEquals(tc[1], kp.getPublicKey().toString());
		}
	}

	@DisplayName("m2; from seed; mitum")
	@Test
	void fromSeedReturnsSameKeyPairWithMitum() {
		String[][] tcs = {
				{ "mitum2; this is the first seed; mitum2", "8AakHHV4Tqs5eg9vqikUnZDjm4WtK6XQrv8q75rKj3RKmpr",
						"rmrjcJ4KDJHgZfwDf1EYXeqVW5BF38w2xAJvpCrXyZutmpu" },
				{ "mitum2; this is the second seed; mitum2", "6QSCo7hzLMJPcbd7wRCaENhZxCw5mk8eyscrhrmih3kVmpr",
						"dRtHBpvjH34JUgCFump1kEK4DzJYXJwA7Digu9M9stkDmpu" },
				{ "mitum2; this is the third seed; mitum2", "5cFG7ZojPUoeomcSGVvmcsRPUTwtPXZ53aXjC95dSbxompr",
						"i61vhMhtmaR2nNRZxVB3GKkWVx9ZiyKBrVdUVb96M1gJmpu" },
				{ "mitum2; this is the forth seed; mitum2", "4Wr8s1ncyvShbnEXSvMCPNur5kDbrxGzdeqnSEfYmkzNmpr",
						"bcjvssG242HrPD5hzVRx9ZMN76WpwKjVSjuQjdGwqR67mpu" },
				{ "mitum2; this is the fifth seed; mitum2", "5QGEgxR55xWe7P27DLNiGYDgEF9ZDzc2yae8z9wWPXxWmpr",
						"dVShB9wggdJFNHGnp4oPoT1Utcv3Fn5hmRrLu1LEVAFRmpu" },
				{ "mitum2; this is the sixth seed; mitum2", "85gCkxdpfYdBdBFBCkVwBxsAYjXbgcGHqsknXza9RPn2mpr",
						"cLys6ofz6juArMnTTUKv5znozuAgt2LGGPYDP7pRJyMPmpu" },
				{ "mitum2; this is the seventh seed; mitum2", "8hr15Rsc55qg7myCJaovRtCuRd4N4UMZc9HSTx977EhSmpr",
						"oQHXje8y8iNjXcvtcJjsTwutrsU2YTkYPg4ffJQ9CdESmpu" },
				{ "mitum2; this is the ninth seed; mitum2", "5Y3Pz3owSPcqfQQivp7Z5cnRrzpk3rrBzbzLhA64xYC8mpr",
						"jbzzEeE7hVdoBtd4EWgnJ2xYWHxKLzaeKDcQNAnciQC7mpu" },
				{ "mitum2; this is the tenth seed; mitum2", "8qPoAb5fP6amXbVAGF9CddrbHcXARWW8292rpngLNb5cmpr",
						"ifSXpZvFR2hVr2LYSeUacxR6EQBcX15qor3QzGoWmTRqmpu" },
				{ "mitum2; this is the eleventh seed; mitum2", "5oyZz1yfVSc5wzsavQGQmVZ7TMJqs18tHuzGxaMP1eRFmpr",
						"sxjkyKaV4xorUsGmbN4KYgu3XbpwcmT7D3WzGLxcxPNempu" },
		};

		for (String[] tc : tcs) {
			M2KeyPair kp = M2KeyPair.fromSeed(tc[0]);
			assertEquals(tc[1], kp.getPrivateKey().toString());
			assertEquals(tc[2], kp.getPublicKey().toString());
		}
	}

	@DisplayName("m2; sign")
	@Test
	void signReturnsValidSignature() {
		String msg = "this is the message to sign";
		String[][] tcs = {
				{ "F1wL8DkcP4mjCUWB9kRbzRZos4HPVy4Fb5XMQ1zWwnxhmpr",
						"381yXZEWq6ejVbxm6us3hLhLcoUVojjY5mUBa4zCnPHZj53UvZrWXbxhctgZCaF4nrYomiR4PxFGGHtBLwzifoHgdS6mjC6z" },
				{ "HW9jquPB5ZEoAxJcXrd6w5dEdqtuhHSwDzSAxeiBnUKympr",
						"381yXYz1kSoRN7KyX5LGdcieQYPSHWaxJa6xEHXesh1gumnFexyPuptnF1iHRad7qNLcRTc2m5xCWRtNTSDFtRivnGD6iWVJ" },
				{ "56nUSEAnihm6DiiMJqbFtpTUdc24z1tShCWUhvSgGNpempr",
						"381yXZ5K6W1K3SqS9xZ5bNUmMpTVUxUoxJYDpG6Gx6LDNWVnm6T4SmHmyAi57GB3dpCZttX8sJFqNAaX43PscqQuQvwhdB6t" },
				{ "CQvfFr8jtxJUtkcjcXVz7QDaoSXhUMVaXwLpBPRSZPt1mpr",
						"AN1rKvtP2Df54z65YhX2V6bv4BDWhJfzoQohYoTunh81834BbkgBju5NXp2mabynoZwa7A6AgG7fePuHHiLMMhBuf7DsYVhXF" },
				{ "4rR4FbwjxheLCTybmeLtbZCtuLkKqFXzLmFhUYAgNLFimpr",
						"381yXYxBsVQKSLC6teY8HDqTnb4dNnYWZzX94pfsQtxYBAWSs7PAW8bcrX6BEYPEAffhcsaEd7R761CdP6AEXB6o6V2gdVs3" },
				{ "8EJNUp3Hmtrcp4scMSbAqPNMPdw7Za3mSWtSRTLnbcrqmpr",
						"AN1rKvtfqU8bmvbspLNCysGTeZRcFrwAu8b49yK5WzVNmnjVEZ41ps4aEoASKj6ceQSeo3K4QT3Ptpsrhm1tauGApPYdqZoe4" },
				{ "GEmtmRYVQSDGGYmfJC6MmVnrACcvShAXbYEQGGt9iK6mpr",
						"381yXZT3EzwyJ3avnriHv3gFVGFm76qd4sRo8GHkAXbY4W7hq8xgoGJLBaHo7eVXQVHYQR1KAAAGcfZaWbuLU5cccB2t9k7J" },
				{ "3BrSzE7g3MZpwSJ684C75zNnv6Nip1eiA15vycVJrTMnmpr",
						"AN1rKvteVSYUjAUx5oYTW3MXRoZHbpumwYGpuYjZdEvSqmKV65cUBzZvnS5ZrHSHC1QtC1PELzseq93p2qahtQiXGQxBPoXC5" },
				{ "KHihLt6HhrKveLCkrZo1a9AxMcPN7GTsVjJaA6411WKmpr",
						"AN1rKvtXYw6Sh7r33gqoSk121WqhMAszDVum6RomLDqWkiECFaiW6gPBHDjehNS2HT1LmsrqSkq6ziPgcsW4ihJ2nASjc4MaJ" },
				{ "DYVgtVqpoRdeCks6yMRuAh8MfTK32xF7LWBToHUx9LTEmpr",
						"AN1rKvtgqCGZ87Hy57dhjDF14qCfxGndxCfGLDbwXbyy7HvXGuoVzMNsRLGXZNR6AmHVQM4PvKa8FxzBGvqpTkacisVjDdUqa" },
		};

		for (String[] tc : tcs) {
			M2KeyPair kp = M2KeyPair.from(tc[0]);
			assertEquals(tc[0], kp.getPrivateKey().toString());

			String sign = Base58.encode(kp.sign(msg));
			assertEquals(tc[1], sign);
		}
	}
}
