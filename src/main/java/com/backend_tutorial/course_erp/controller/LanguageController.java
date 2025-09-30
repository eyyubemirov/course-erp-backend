package com.backend_tutorial.course_erp.controller;

import com.backend_tutorial.course_erp.models.base.BaseResponse;
import com.backend_tutorial.course_erp.models.mappers.LanguageEntityMapper;
import com.backend_tutorial.course_erp.models.mybatis.language.Language;
import com.backend_tutorial.course_erp.models.payload.language.LanguagePayLoad;
import com.backend_tutorial.course_erp.services.language.LanguageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/languages")
@RequiredArgsConstructor
public class LanguageController {

    private final LanguageService languageService;


    @PostMapping
    public BaseResponse<Void> insert(@RequestBody LanguagePayLoad languagePayLoad){
        languageService.insert(LanguageEntityMapper.INSTANCE.toEntity(languagePayLoad));
        return BaseResponse.success();
    }
    @PutMapping("/{id}")
    public BaseResponse<Void> update(@PathVariable("id") long id, @RequestBody LanguagePayLoad languagePayLoad){
        languageService.update(LanguageEntityMapper.INSTANCE.toEntity(languagePayLoad),id);
        return BaseResponse.success();
    }

    @GetMapping("/localizable")
    public BaseResponse<List<Language>> getAllLanguagesIsLocalize(){
        return BaseResponse.success(languageService.getAllLanguagesIsLocalize());
    }
}