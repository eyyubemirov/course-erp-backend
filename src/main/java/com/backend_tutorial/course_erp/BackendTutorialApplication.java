package com.backend_tutorial.course_erp;

import com.backend_tutorial.course_erp.models.mappers.CourseEntityMapper;
import com.backend_tutorial.course_erp.models.payload.auth.SignUpPayload;
import com.backend_tutorial.course_erp.models.properties.security.SecurityProperties;
import com.backend_tutorial.course_erp.repository.UserRepository;
import com.backend_tutorial.course_erp.services.redis.RedisService;
import com.backend_tutorial.course_erp.services.security.AccessTokenManager;
import com.backend_tutorial.course_erp.services.user.UserService;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.annotation.MapperScan;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

@SpringBootApplication
@MapperScan("com.backend_tutorial.course_erp.repository")
@RequiredArgsConstructor
public class BackendTutorialApplication implements CommandLineRunner {
//	private final UserRepository userRepository;
//	private  final SecurityProperties securityProperties;
//    private final AccessTokenManager accessTokenManager;
//	private final UserService userService;
//	private final PasswordEncoder passwordEncoder;
//	private final RedissonClient client;
//	private final RedisService redisService;


	public static void main(String[] args) {
		SpringApplication.run(BackendTutorialApplication.class, args);
	}



	@Override
	public void run(String... args) throws Exception {


//		redisService.set("salam",122,5);
//		redisService.get("salam");
//		System.out.println(client);
//		RBucket<String> testKey =client.getBucket("key");
//		testKey.set("value", Duration.of(5, ChronoUnit.SECONDS));
//		RBucket<String> testKey1 =client.getBucket("key");
//		 String value=testKey1.get();
//		System.out.println(value);
//
//		Thread.sleep(6000);
//		RBucket<String> testKey2 =client.getBucket("key");
//		String value2=testKey1.get();
//		System.out.println(value2);


//
//		SignUpPayload payload=new SignUpPayload();
//		payload.setName("1233");
//		payload.setCourseName("456");
//
//		System.out.println(CourseEntityMapper.INSTANCE.fromSignUpPayload(payload));


//		User user= User.builder()
//				.email("eyyub@mail.com")
//				.name("test")
//				.surname("test")
//				.roleId(1L)
//				.phoneNumber("123123")
//				.status(UserStatus.ACTIVE)
//				.password(passwordEncoder.encode("123123"))
//				.build();
//		userService.insert(user);
//		System.out.println(userService.getByEmail("eyyub@mail.com"));
//		User user =User.builder().email("eyyub@email.com").build();
//		user.setId(1L);
//		final String token=accessTokenManager.generator(user);
//		System.out.println(token);
//		System.out.println(accessTokenManager.read(token).get("email",String.class));
//		KeyPairGenerator keyGenerator = KeyPairGenerator.getInstance("RSA");
//		keyGenerator.initialize(2048);
//		KeyPair kp = keyGenerator.genKeyPair();
//		PublicKey publicKey = kp.getPublic();
//		PrivateKey privateKey = kp.getPrivate();
//
//		String encodedPublicKey = Base64.getEncoder().encodeToString(publicKey.getEncoded());
//		String encodedPrivateKey = Base64.getEncoder().encodeToString(privateKey.getEncoded());
//
//		System.out.println(convertToPublicKey(encodedPublicKey));
//
//		System.out.println();
//
//		System.out.println(convertToPrivateKey(encodedPrivateKey));

	}

//	private static String convertToPrivateKey(String key) {
//		StringBuilder result = new StringBuilder();
//		result.append("-----BEGIN PRIVATE KEY-----\n");
//		result.append(key);
//		result.append("\n-----END PRIVATE KEY-----");
//		return result.toString();
//	}
//
//	private static String convertToPublicKey(String key) {
//		StringBuilder result = new StringBuilder();
//		result.append("-----BEGIN PUBLIC KEY-----\n");
//		result.append(key);
//		result.append("\n-----END PUBLIC KEY-----");
//		return result.toString();
//	}
//	@Override
//	public void run(String... args)throws Exception{
//		userRepository.insert(User.builder()
//						.name("Eyyub")
//						.surname("Emirov")
//						.status(UserStatus.ACTIVE)
//						.roleId(1L)
//						.email("eyyubemirov@esss.com")
//						.phoneNumber("5897797")
//						.password("1234")
//				.build());
//	}
}
