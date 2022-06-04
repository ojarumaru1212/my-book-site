package com.books.app.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import com.books.app.common.constant.ParameterConstants;
import com.books.app.domain.model.RegistBookRequestForm;
import com.books.app.domain.model.RegistBookResponseForm;
import com.books.app.domain.service.RegistBookService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 書籍登録 コントローラークラス
 *
 */
@Controller
public class RegistBookController {

	private final RegistBookService service;
	private final ObjectMapper mapper;

	@Autowired
	public RegistBookController(RegistBookService service, ObjectMapper mapper) {
		this.service = service;
		this.mapper = mapper;
	}

	/**
	 * タスクを登録する
	 * 
	 * @return true:登録件数1件、false:登録件数1件以外
	 * @throws JsonProcessingException
	 */
	@PostMapping(ParameterConstants.REQ_PARAM_REGIST_BOOK)
	@ResponseBody
	public String registBook(@RequestBody @Valid RegistBookRequestForm req, BindingResult bindingResult)
			throws JsonProcessingException {

		boolean registSuccessFlg = false;
		List<String> messageList = new ArrayList<>();
		String json = null;

		// 入力チェック
		if (bindingResult.hasErrors()) {
			// エラーメッセージをリストに格納
			for (ObjectError error : bindingResult.getAllErrors()) {
				messageList.add(error.getDefaultMessage());
			}

			RegistBookResponseForm regBookResForm = RegistBookResponseForm.builder().messages(messageList)
					.registSuccessFlg(registSuccessFlg).build();
			// シリアライズ
			json = mapper.writeValueAsString(regBookResForm);
			return json;
		}

		// 書籍登録
		registSuccessFlg = service.RegistBook(req);

		RegistBookResponseForm regBookResForm = RegistBookResponseForm.builder().registSuccessFlg(registSuccessFlg)
				.build();

		// シリアライズ
		json = mapper.writeValueAsString(regBookResForm);
		return json;
	}

}