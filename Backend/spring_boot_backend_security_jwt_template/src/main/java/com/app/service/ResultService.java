package com.app.service;

import com.app.dao.ResultDao;
import com.app.dto.ReqResultDto;
import com.app.dto.ResResultDto;

public interface ResultService {
ResResultDto generateResult(ReqResultDto resultDto);

}
