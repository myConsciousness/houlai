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
-- USER ACCOUNT Table
INSERT INTO
  USER_ACCOUNT (
    USER_ID,
    PASSWORD,
    USER_FIRST_NAME,
    USER_LAST_NAME,
    CREATION_USER,
    CREATED_AT,
    UPDATE_USER,
    UPDATED_AT
  )
VALUES
  (
    'M000001',
    '$2a$10$FxoxIbxWaboSCWw.A3AJDOf70voqnkMfur7vNWP7yDRfXE2aCLV56',
    'Shinya',
    'Kato',
    'M000001',
    NOW(),
    'M000001',
    NOW()
  );
-- RESOURCE Table
INSERT INTO
  RESOURCE (
    RESOURCE_NAME,
    EXTENSION,
    RESOURCE_TYPE,
    CREATION_USER,
    CREATED_AT,
    UPDATE_USER,
    UPDATED_AT
  )
VALUES
  (
    'Object1',
    'java',
    3,
    'M000001',
    NOW(),
    'M000001',
    NOW()
  ),
  (
    'Object1',
    'java',
    3,
    'M000001',
    NOW(),
    'M000001',
    NOW()
  ),
  (
    'Object1',
    'java',
    3,
    'M000001',
    NOW(),
    'M000001',
    NOW()
  ),
  (
    'Object1',
    'java',
    3,
    'M000001',
    NOW(),
    'M000001',
    NOW()
  ),
  (
    'Object1',
    'java',
    3,
    'M000001',
    NOW(),
    'M000001',
    NOW()
  );
commit;
