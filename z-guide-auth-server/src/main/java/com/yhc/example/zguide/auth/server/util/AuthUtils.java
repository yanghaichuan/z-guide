package com.yhc.example.zguide.auth.server.util;


import cn.hutool.core.codec.Base64;
import cn.hutool.core.util.CharsetUtil;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Slf4j
@UtilityClass
public class AuthUtils {
	private final String BASIC_ = "Basic ";

	/**
	 * 从header 请求中的clientId/clientsecect
	 *
	 * @param header header中的参数
	 * @throws RuntimeException if the Basic header is not present or is not valid
	 *                          Base64
	 */
	public String[] extractAndDecodeHeader(String header)
			throws IOException {

		byte[] base64Token = header.substring(6).getBytes("UTF-8");
		byte[] decoded;
		try {
			decoded = Base64.decode(base64Token);
		} catch (IllegalArgumentException e) {
			throw new RuntimeException(
					"Failed to decode basic authentication token");
		}

		String token = new String(decoded, CharsetUtil.UTF_8);

		int delim = token.indexOf(":");

		if (delim == -1) {
			throw new RuntimeException("Invalid basic authentication token");
		}
		return new String[]{token.substring(0, delim), token.substring(delim + 1)};
	}

	/**
	 * *从header 请求中的clientId/clientsecect
	 *
	 * @param request
	 * @return
	 * @throws IOException
	 */
	public String[] extractAndDecodeHeader(HttpServletRequest request)
			throws IOException {
		String header = request.getHeader(HttpHeaders.AUTHORIZATION);

		if (header == null || !header.startsWith(BASIC_)) {
			throw new RuntimeException("请求头中client信息为空");
		}

		return extractAndDecodeHeader(header);
	}
}
