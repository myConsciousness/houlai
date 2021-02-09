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

package org.thinkit.houlai.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thinkit.houlai.catalog.ResourceType;
import org.thinkit.houlai.dao.ResourceDao;
import org.thinkit.houlai.entity.Resource;

import lombok.NonNull;

/**
 * 「Resource」テーブルの操作を定義したサービスクラスです。
 *
 * @author Kato Shinya
 * @since 1.0.0
 */
@Service
public final class ResourceService {

    /**
     * 「Resource」テーブルとマッピングを行うDao
     */
    @Autowired
    ResourceDao resourceDao;

    /**
     * 引数として渡された一意のIDに紐づくレコードを取得します。
     *
     * @param id 一意のID
     * @return 引数として渡された一意のIDに紐づくレコード
     *
     * @exception NullPointerException 引数として {@code null} が渡された場合
     */
    public Resource findById(@NonNull final Integer id) {
        return this.resourceDao.findById(id);
    }

    /**
     * 引数として渡された値に紐づくレコードを取得します。
     *
     * @param resourceType リソース種別
     * @param resourceName リソース名
     * @param extension    拡張子
     * @return 引数として渡された値に紐づくレコード
     *
     * @exception NullPointerException 引数として {@code null} が渡された場合
     */
    public List<Resource> findOverview(@NonNull ResourceType resourceType, @NonNull String resourceName,
            @NonNull String extension) {

        final Map<String, Object> criteria = new HashMap<>(3);
        criteria.put("resourceType", resourceType);
        criteria.put("resourceName", resourceName);
        criteria.put("extension", extension);

        return this.resourceDao.findOverview(criteria);
    }
}
