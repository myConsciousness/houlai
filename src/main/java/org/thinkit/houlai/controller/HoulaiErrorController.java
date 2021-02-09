/*
 * Copyright 2021 Kato Shinya.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package org.thinkit.houlai.controller;

import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.servlet.ModelAndView;

import lombok.NonNull;

@Controller
@RequestMapping("/error")
public final class HoulaiErrorController implements ErrorController {

    /**
     * エラーページのパスを返す。
     *
     * @return エラーページのパス
     */
    @Override
    public String getErrorPath() {
        return "/error";
    }

    /**
     * HTML レスポンス用の ModelAndView オブジェクトを返す。
     *
     * @param req リクエスト情報
     * @param mav レスポンス情報
     * @return HTML レスポンス用の ModelAndView オブジェクト
     */
    @RequestMapping(produces = MediaType.TEXT_HTML_VALUE)
    public ModelAndView get(@NonNull final ModelAndView modelAndView,
            @NonNull final HttpServletRequest httpServletRequest) {

        final HttpStatus status = this.getHttpStatus(httpServletRequest);
        modelAndView.addObject("status", status.value());
        modelAndView.setStatus(status);

        this.getErrorAttributes(httpServletRequest).forEach((key, value) -> {
            modelAndView.addObject(key, value);
        });

        modelAndView.setViewName("error");

        return modelAndView;
    }

    /**
     * HTTPサーブレットリクエストから詳細エラー情報を抽出し返却します。
     *
     * @param httpServletRequest HTTPサーブレットリクエスト
     * @return 詳細エラー情報
     *
     * @exception NullPointerException 引数として {@code null} が渡された場合
     */
    private Map<String, Object> getErrorAttributes(@NonNull final HttpServletRequest httpServletRequest) {
        return new DefaultErrorAttributes().getErrorAttributes(new ServletWebRequest(httpServletRequest),
                ErrorAttributeOptions.of(ErrorAttributeOptions.Include.BINDING_ERRORS,
                        ErrorAttributeOptions.Include.EXCEPTION, ErrorAttributeOptions.Include.MESSAGE,
                        ErrorAttributeOptions.Include.STACK_TRACE));
    }

    /**
     * HTTPサーブレットリクエストからHTTPステータスを抽出し返却します。
     *
     * @param httpServletRequest HTTPサーブレットリクエスト
     * @return HTTPステータス
     *
     * @exception NullPointerException 引数として {@code null} が渡された場合
     */
    private HttpStatus getHttpStatus(@NonNull final HttpServletRequest httpServletRequest) {

        final Object statusCode = httpServletRequest.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        for (HttpStatus httpStatus : HttpStatus.values()) {
            if (String.valueOf(httpStatus.value()).equals(statusCode.toString())) {
                return httpStatus;
            }
        }

        throw new IllegalStateException();
    }
}
