package org.chzz.adapter.demo.engine;

import java.util.List;

import org.chzz.adapter.demo.mode.NormalModel;
import retrofit.Call;
import retrofit.http.GET;

/**
 * 作者:copy 邮件:2499551993@qq.com
 * 创建时间:15/9/17 上午10:19
 * 描述:
 */
public interface ApiEngine {
    @GET("normalModels.json")
    Call<List<NormalModel>> getNormalModels();
}