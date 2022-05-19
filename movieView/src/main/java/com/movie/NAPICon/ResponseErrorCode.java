package com.movie.NAPICon;

/*
 * 
HTTP 상태 코드(오류 유형)												오류 발생 원인																													해결 방법
400(요청 변수 확인)											필수 요청 변수가 없거나 요청 변수 이름이 잘못된 경우													API 레퍼런스에서 필수 요청 변수를 확인합니다.
400(요청 변수 확인)											요청 변수의 값을 URL 인코딩으로 변환하지 않고 전송한 경우										API 레퍼런스에서 해당 요청 변수를 URL 인코딩으로 변환해야 하는지 확인합니다.
401(인증 실패)													클라이언트 아이디와 클라이언트 시크릿이 없거나 잘못된 값인 경우							내 애플리케이션 메뉴에서 클라이언트 아이디와 클라이언트 시크릿을 확인합니다.
401(인증 실패)													클라이언트 아이디와 클라이언트 시크릿을 
																			HTTP 헤더에 정확히 설정하지 않고 호출한 경우																클라이언트 아이디와 클라이언트 시크릿은 URL이나 폼이 아니라 지정된 이름의 HTTP 요청 헤더로 전송해야 합니다.
401(인증 실패)													API 권한이 설정되지 않은 경우																							내 애플리케이션 메뉴의 API 설정 탭에서 해당 API가 추가되어 있는지 확인합니다.

401(인증 실패)													네이버 로그인 API를 호출할 때 
																			접근 토큰 파라미터(access_token)가 없거나 
																			잘못된 값(만료된 접근 토큰)을 설정한 경우																		접근 토큰이 HTTP 요청 헤더에 정확하게 설정됐는지, 값이 유효한지 확인합니다.

403(서버가 허용하지 않는 호출)						HTTPS가 아닌 HTTP로 호출한 경우																					API 요청 URL의 프로토콜이 HTTPS인지 확인합니다.
403(호출 금지)													필수 요청 변수가 없거나 요청 변수 이름이 잘못된 경우													API 레퍼런스에서 필수 요청 변수를 확인합니다.
403(호출 금지)													요청 변수의 값을 URL 인코딩으로 변환하지 않고 전송한 경우										API 레퍼런스에서 해당 요청 변수를 URL 인코딩으로 변환해야 하는지 확인합니다.
404(API 없음)													API 요청 URL이 잘못된 경우																								API 요청 URL에 오류가 있는지 확인합니다.

405(메서드 허용 안 함)										HTTP 메서드를 잘못 호출한 경우. 
																			POST 방식으로 호출해야 하는데 GET 방식으로 호출한 경우 등입니다.						API 레퍼런스에서 HTTP 메서드를 확인합니다.
																			
429 (호출 한도 초과 오류)								오픈 API를 호출할 때 하루 허용량을 초과한 경우															하루 허용량 초과 시 제휴 신청을 합니다.
429 (초당 호출 한도 초과 오류)						검색 API를 호출할 때 초당 호출량을 초과한 경우															https://developers.naver.com/notice/article/10000000000030659365 참고
500(서버 오류)													필수 요청 변수가 없거나 요청 변수 이름이 잘못된 경우													API 레퍼런스에서 필수 요청 변수를 확인합니다.
500(서버 오류)													요청 변수의 값을 URL 인코딩으로 변환하지 않고 전송한 경우										API 레퍼런스에서 해당 요청 변수를 URL 인코딩으로 변환해야 하는지 확인합니다.
500(서버 오류)													API 호출은 정상적으로 했지만, 
																			API 서버 유지 보수나 시스템 오류로 인한 오류가 발생한 경우										개발자 포럼에 오류를 신고합니다.
 */

public enum ResponseErrorCode {
	RequestSucess(200),
	RequestParam(400), AuthFalse(401),ServerDenied(403),
	NotFound(404),MethodDenied(405),RequestMaxOut(429),
	ServerError(500);
	
	private int errorCode;
	
	ResponseErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	
	
}
