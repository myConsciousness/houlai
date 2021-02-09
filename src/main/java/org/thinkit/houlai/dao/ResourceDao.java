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

package org.thinkit.houlai.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.thinkit.houlai.entity.Resource;

import lombok.NonNull;

/**
 * 「Resource」テーブルとマッピングを行うDaoクラスです。
 *
 * @author Kato Shinya
 * @since 1.0.0
 */
@Mapper
public interface ResourceDao {

    /**
     * 引数として渡された一意のIDに紐づくレコードを取得します。
     *
     * @param id 一意のID
     * @return 引数として渡された一意のIDに紐づくレコード
     *
     * @exception NullPointerException 引数として {@code null} が渡された場合
     */
    public Resource findById(@NonNull final Integer id);

    /**
     * 引数として渡された値に紐づくレコードを取得します。
     *
     * @param criteria 検索条件
     * @return 引数として渡された値に紐づくレコード
     *
     * @exception NullPointerException 引数として {@code null} が渡された場合
     */
    public List<Resource> findOverview(@NonNull Map<String, Object> criteria);
}
