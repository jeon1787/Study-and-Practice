'use strict';
const naverLogin = new naver.LoginWithNaverId(
			{
				clientId: "9pmuWV3hdE23LuAsDCL6",
				callbackUrl: "http://localhost:9080/OAuth2-study/callback",
				loginButton: {color: "green", type: 2, height: 40}
			}
		);
 naverLogin.init(); // 로그인 설정

//네이버 로그인 연동
//1) 요청 url
//--샘플--
// https://nid.naver.com/oauth2.0/authorize
// ?response_type=code
// &client_id=CLIENT_ID
// &state=STATE_STRING
// &redirect_uri=CALLBACK_URL

//2) 콜백 응답 정보 : authorization_code 발급
// API 요청 성공시 : http://콜백URL/redirect?code={code값}&state={state값}
// API 요청 실패시 : http://콜백URL/redirect?state={state값}&error={에러코드값}&error_description={에러메시지}

//3) 접근 토큰 발급 요청 : access_token 발급
//--샘플--
// https://nid.naver.com/oauth2.0/token
// ?grant_type=authorization_code                   --인증 과정에 대한 구분값
//                                                      1) 발급:'authorization_code'
//                                                      2) 갱신:'refresh_token'
//                                                      3) 삭제: 'delete'
// &client_id=jyvqXeaVOVmV                          --애플리케이션 등록 시 발급받은 Client ID 값
// &client_secret=527300A0_COq1_XV33cf              --애플리케이션 등록 시 발급받은 Client secret 값
// &code=EIc5bFrl4RibFls1&state=9kgsGTfH4j7IyAkg    --로그인 인증 요청 API 호출에 성공하고 리턴받은 인증코드값 (authorization code)
// 그외 선택적으로 state/refresh_token/access_token/service_provider 요청가능
//--결과(json)--
// access_token(String) : 접근 토큰, 발급 후 expires_in 파라미터에 설정된 시간(초)이 지나면 만료됨
// refresh_token(String) : 갱신 토큰, 접근 토큰이 만료될 경우 접근 토큰을 다시 발급받을 때 사용
// token_type(String) : 접근 토큰의 타입으로 Bearer와 MAC의 두 가지를 지원
// expires_in(String) : 접근 토큰의 유효 기간(초 단위)

//4)접근 토큰을 이용하여 프로필 API 호출하기
//--샘플--
//curl  -XGET "https://openapi.naver.com/v1/nid/me" \
//      -H "Authorization: Bearer AAAAPIuf0L+qfDkMABQ3IJ8heq2mlw71DojBj3oc2Z6OxMQESVSrtR0dbvsiQbPbP1/cxva23n7mQShtfK4pchdk/rc="
//--결과(json)--
// resultcode(String) : API 호출 결과 코드
// message(String) : API 호출 결과 메세지
// response/id(String) : 동일인 식별 정보
// response/email(String) : 사용자 메일 주소
// response/nickname(String) : 사용자 별명
// response/name(String) : 사용자 이름