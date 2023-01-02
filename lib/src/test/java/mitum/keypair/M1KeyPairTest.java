package mitum.keypair;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.bitcoinj.core.Base58;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class M1KeyPairTest {
	@DisplayName("m1; random; val")
	@Test
	void randomNotThrowsException() {
		for (int i = 0; i < 1000; i++) {
			assertDoesNotThrow(() -> {
				M1KeyPair kp = M1KeyPair.random();
				kp.sign("mitum");
			});
		}
	}

	@DisplayName("m1; from private key; val")
	@Test
	void fromPrivateKeyReturnsValidKeyPair() {
		for (int i = 0; i < 1000; i++) {
			M1KeyPair kp1 = M1KeyPair.random();
			M1KeyPair kp2 = M1KeyPair.from(kp1.getPrivateKey());
			M1KeyPair kp3 = M1KeyPair.from(kp1.getPrivateKey().toString());

			assertEquals(kp1.getPrivateKey().toString(), kp2.getPrivateKey().toString());
			assertEquals(kp1.getPrivateKey().toString(), kp3.getPrivateKey().toString());
			assertEquals(kp1.getPublicKey().toString(), kp2.getPublicKey().toString());
			assertEquals(kp1.getPublicKey().toString(), kp3.getPublicKey().toString());
		}
	}

	@DisplayName("m1; from private key; mitum")
	@Test
	void fromPrivateKeyReturnsSameKeyPairWithMitum() {
		String[][] tcs = {
				{ "L39Fcnf2arMoxBrrW8miPLgnZ81mfAKm3Gd1mtdCM7MmGYrRSBVxmpr",
						"22cEQjWB6T6FYMJj5hCet4LR2bLKWUHk99NobAwt3fxBfmpu" },
				{ "L4XvhLamJkzUGyQ9FLSMoU9xPRuETs3XrvQS75bgbXjeDTNu7FPEmpr",
						"fwFHdoD4X9patKkUcuWkqCwWvrGuxSCcpagdQ2cWUWgompu" },
				{ "L1fBXgHFxX6q41yTdtYbugvahcQ7EBW4Td6NrHrMEFAPiyktCEcEmpr",
						"27HW8eebj9o75bjsJMuy2NkzmJgc2BhxnTDt87yuSe7vnmpu" },
				{ "KxaKvUSuki1PtqHqGJkf5fAFxxyEnVvCzHkkLU8V8uY8xjp4mbWgmpr",
						"2ArCzebgjMTte3heJaqFNUv6SsYwQtbADRwqbVfg19fasmpu" },
				{ "KzgfwNaDTewhG6j2i4HMzMiTPy3kQP5noJCBLr6Yvw8pUbwxtYrHmpr",
						"27URAbv3HZvBJ7d6quruKaxtKEFxU6Eudw11ZnpZ99zKimpu" },
				{ "KwZ3RWSqkKx31Kiu7BNvZYxWC2DRw6fgqyme9npsfoAtxs5JQMewmpr",
						"rKTEip6xot1ihrdoTjYeZRUwoxecUVS7BPdEhASg9Ge9mpu" },
				{ "L1Qhpc8aaeDsSHmqEVygN7u2oxEpBD8jQFn1esipfR6QbJqW6koAmpr",
						"zNxEWqfCGEjHAiSgtR7Q2tncHApPLmvY23LSu7hPALdkmpu" },
				{ "L1kwA3Wa9F2euHrthyqJXfe7Nx5zKAFT8gpEZQ2yDGnxZcopH3Q2mpr",
						"cb41AYriJkr82qMMXTV8KNwQUUUAWe395FrDPpxHDiNSmpu" },
				{ "L3QJ3k8NvX1AyoY3VUjhbHxHePENsyN5Yn2U6GQW8JmDzychu4Bjmpr",
						"22MQHBp1JbdFjtqHXFdzju2mmBBPZ51hVV6s4GzGBNTe1mpu" },
				{ "L1i9ozxhjWjynhdUtKorhJU4DNvSLCB1mP78nQoxvgLaBgPp9rPjmpr",
						"mXaxvoPtwipVNxNeUetfc1EnXbmMbU1p66NSLXPgEfZbmpu" },
		};

		for (String[] tc : tcs) {
			M1KeyPair kp = M1KeyPair.from(tc[0]);
			assertEquals(tc[0], kp.getPrivateKey().toString());
			assertEquals(tc[1], kp.getPublicKey().toString());
		}
	}

	@DisplayName("m1; from seed; mitum")
	@Test
	void fromSeedReturnsSameKeyPairWithMitum() {
		String[][] tcs = {
				{ "mitum1; this is the first seed; mitum1",
						"Kz5hawJSFn9hL83YfADR3zTT5j6YJ31pTUPVWXhQgskzaqdV3h8dmpr",
						"22DN32dAUwg3fog8jDRHFc6xebp1fMQc444CsmhUSMot9mpu" },
				{ "mitum1; this is the second seed; mitum1",
						"Ky5YbfUDwGxugSjeiqACLhSCvDvYvb3wcenEai33MzSe1up1VeMqmpr",
						"i7mHMvZ47gkqhimxRKtzzpcEKa1fd9FTSejVPNne2bnQmpu" },
				{ "mitum1; this is the third seed; mitum1",
						"KzkDLnRiEsi25h7t8QCzaawtrhH76f7RDvw4ZxdttQYwVsnXm4bBmpr",
						"w1N7Kmhju2Ldp4MiP1dhmVnjmXgcjzeKkqfGux1xAwtdmpu" },
				{ "mitum1; this is the forth seed; mitum1",
						"KyaU8LCgBgREGdk2TgT6ABVvUvVeu3PuxNmaJGsYLpmD6vyrbNGTmpr",
						"nHj4kEDfpT5B2zkzcnvjTZgtFjxMABfdymkvGzPH8iojmpu" },
				{ "mitum1; this is the fifth seed; mitum1",
						"Ky7CX5byxmu5L8oQLJgaKdQD8jAJZvFyMsCJytFXYNdLJ627GCqfmpr",
						"yYwjCuUXvuBZ4KjzGmrAfEswjLDev9ZVKev2mBifExyfmpu" },
				{ "mitum1; this is the sixth seed; mitum1",
						"KxyLoGhvE57E2oS7PyEX769yyUMVokypfmseLViiXUdPbVJEjCE8mpr",
						"ox2o949vpYZ7Ut9rKya9xngFjH4QP2V6UT3zTvNJb2zDmpu" },
				{ "mitum1; this is the seventh seed; mitum1",
						"KyaKewXw2xpejhjpAiqp33YCihi1vqmiR3ZPB3C1u6xNX6dL8d2Umpr",
						"xLDrZ8DoUnchSwn9hLAiyT58jdr63vh2t8Yq8qiMiWnNmpu" },
				{ "mitum1; this is the ninth seed; mitum1",
						"L16AknrZ9QJYBpbMKTeLMQgJLqxQFMMfDxcMtHXtkJcz1npiPZ6Wmpr",
						"jVMd9oZmFndHxQFa5hdSMDJAQzTCLHP21sb7MWcUrTvQmpu" },
				{ "mitum1; this is the tenth seed; mitum1",
						"KyuoqYpJTrgPXb83ETjahsXFuCQurchEnqFSdUhKGCiUGmXE8KmQmpr",
						"21Jj1pdnMG9WbGgfkT94xvUwuFWcLTikZH3tWzkPmPjBGmpu" },
				{ "mitum1; this is the eleventh seed; mitum1",
						"KzuyJBGF1RFeDQtPtgXfZPVDRmFmQKNiSRX7N26FXC9TEdNK6d8wmpr",
						"28Jf1dLWLTHHN5jTSperp3QGbGP7ycJhqXycfBYVtXcbmmpu" },
		};

		for (String[] tc : tcs) {
			M1KeyPair kp = M1KeyPair.fromSeed(tc[0]);
			assertEquals(tc[1], kp.getPrivateKey().toString());
			assertEquals(tc[2], kp.getPublicKey().toString());
		}
	}

	@DisplayName("m1; sign")
	@Test
	void signReturnsValidSignature() {
		String msg = "this is the message to sign";
		String[][] tcs = {
				{
						"L39Fcnf2arMoxBrrW8miPLgnZ81mfAKm3Gd1mtdCM7MmGYrRSBVxmpr",
						"381yXYoWMWjUVkfwzt43rqVC7Ctcc84doqHr2CXmJ9mxdTuLYQ1MMuj4trFsDkTZHye63wsfe7rf6BkjTF2ac4Nfr45AiWEu"
				},
				{
						"L4XvhLamJkzUGyQ9FLSMoU9xPRuETs3XrvQS75bgbXjeDTNu7FPEmpr",
						"AN1rKvthU5xigfcpSw7xZwW9zz94YmDJst3768WfA1s5eimajssSFJznSMysPjjo7D5xkWs3fuNfDEZqcimSWm2ZYowoJk1hZ"
				},
				{
						"L1fBXgHFxX6q41yTdtYbugvahcQ7EBW4Td6NrHrMEFAPiyktCEcEmpr",
						"381yXZDB8RMRDDe8qcsxVA4s9n6QrRxvHPhsJE4uNYma1tQkcG6Hu7gS38tv5Dk6WauZzCsmc8yf3WN7bMeDJhgHW2CBB9Ca"
				},
				{
						"KxaKvUSuki1PtqHqGJkf5fAFxxyEnVvCzHkkLU8V8uY8xjp4mbWgmpr",
						"381yXZLJeZHiDNKmdSdn8d6xKKxChcPmKvhXaMGpobhKgGpYvGTY5Bisok8QyTksdF1hMQ3aA8vT3ysAysVF3fXuKU2kJbhV"
				},
				{
						"KzgfwNaDTewhG6j2i4HMzMiTPy3kQP5noJCBLr6Yvw8pUbwxtYrHmpr",
						"381yXYz62bq8RQaZXeUiW7B2EUzDZx4YZLy6FDcJCTTHd2M2EpEbkGbUkJQau1JmVdez8fb4pvJePruQXMXvbMyGJ2PjAiJi"
				},
				{
						"KwZ3RWSqkKx31Kiu7BNvZYxWC2DRw6fgqyme9npsfoAtxs5JQMewmpr",
						"381yXYroHkiTbov92fHCBeHawsVaNtUk6ZUKWNNYqywci6PEVhcwBc7ioaa9E6F3SWNZzTpycsf8KXRxFZsApGHFHYJkJnAQ"
				},
				{
						"L1Qhpc8aaeDsSHmqEVygN7u2oxEpBD8jQFn1esipfR6QbJqW6koAmpr",
						"AN1rKvtBsjQWNFZmm4uAR3d5K7AAfSzuFNELfdvnFU4YF4RwrihLJNn9Kbi3cptGT8kez1URHwhcJXNbS9bP3DjGdH4qFx4pS"
				},
				{
						"L1kwA3Wa9F2euHrthyqJXfe7Nx5zKAFT8gpEZQ2yDGnxZcopH3Q2mpr",
						"381yXZ6AaWAjbhfyW5XTKFX9jyC7jDQBRCkHgHuQN5h6ZWbcWSopM7pjLiD1HgqW68zkLXxeG2cuvdNTHN65ZmVZ3GnvTFnP"
				},
				{
						"L3QJ3k8NvX1AyoY3VUjhbHxHePENsyN5Yn2U6GQW8JmDzychu4Bjmpr",
						"381yXZ9T7oFmvHR4hwozJpgjgWb7x3sxzp8KrKN9GE7gFeN4zyvtsXugKTBr9dnvvqyrkaVu9cutZSM1fFnBWb159EHTamxX"
				},
				{
						"L1i9ozxhjWjynhdUtKorhJU4DNvSLCB1mP78nQoxvgLaBgPp9rPjmpr",
						"AN1rKvt6HVPpKYbwU9GsFfceDA8uon3973aNSh9nsCx6JJXoaZVB4nS3CPpFx2oiKtejDcqYZehPg9saMXar2CBvZj7F1A9TD"
				},
		};

		for (String[] tc : tcs) {
			M1KeyPair kp = M1KeyPair.from(tc[0]);
			assertEquals(tc[0], kp.getPrivateKey().toString());

			String sign = Base58.encode(kp.sign(msg));
			assertEquals(tc[1], sign);
		}
	}
}
