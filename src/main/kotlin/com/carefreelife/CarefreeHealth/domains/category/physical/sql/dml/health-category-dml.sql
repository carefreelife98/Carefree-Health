use carefree_health_test;
ALTER TABLE health_category AUTO_INCREMENT = 1;



# 특정 카테고리의 직속 하위 카테고리 찾기
SELECT c.category_name
FROM health_category_closure AS cc
         JOIN health_category AS c
             ON cc.sub_cat_id = c.health_category_id
WHERE cc.parent_cat_id = 5 -- 특정 카테고리 ID
  AND c.usable = true
  AND cc.depth > 0;

# 특정 카테고리의 직속 상위 카테고리 찾기
SELECT c.category_name
FROM health_category_closure AS cc
         JOIN health_category AS c
              ON cc.parent_cat_id = c.health_category_id
WHERE cc.sub_cat_id = 5 -- 특정 카테고리 ID
  AND c.usable = true
  AND cc.depth > 0;

# 트리 전체 조회 (상위-하위 관계)
SELECT ancestor_c.category_name AS ancestor, descendant_c.category_name AS descendant
FROM health_category_closure AS cc
         JOIN health_category AS ancestor_c
             ON cc.parent_cat_id = ancestor_c.health_category_id
         JOIN health_category AS descendant_c
             ON cc.sub_cat_id = descendant_c.health_category_id
ORDER BY cc.parent_cat_id, cc.depth;



# 데이터 삽입 시 처리 (카테고리 추가)
-- 1. 카테고리에 새로운 항목 추가
INSERT INTO health_category (category_name) VALUES ('피지컬 트레이닝');

-- 2. 클로저 테이블에 상위-하위 관계 삽입 (하위 카테고리 추가 시)
INSERT INTO health_category_closure (parent_cat_id, sub_cat_id, depth)
INSERT INTO health_category_closure (parent_cat_id, sub_cat_id, depth)
VALUES (LAST_INSERT_ID(), LAST_INSERT_ID(), 0);
SELECT sub_cat_id, LAST_INSERT_ID(), depth + 1
FROM health_category_closure
WHERE sub_cat_id = 7;  -- 대상 카테고리의 상위 카테고리의 ID

-- 2. 클로저 테이블에 상위-하위 관계 삽입 (최상위 카테고리 추가 시)
INSERT INTO health_category_closure (parent_cat_id, sub_cat_id, depth)
VALUES (LAST_INSERT_ID(), LAST_INSERT_ID(), 0);


### test
INSERT INTO health_category (category_name)
VALUES ('벤치 프레스');

INSERT INTO health_category_closure (parent_cat_id, sub_cat_id)
SELECT parent_cat_id, 4 # 삽입 대상 카테고리의 상위 path 모두 가져오기
FROM health_category_closure
WHERE sub_cat_id = 3
UNION ALL
SELECT 4, 4; # 자기 자신 참조

# 데이터 업데이트 시 처리 (카테고리 업데이트 - usable: true / false)
UPDATE health_category
SET usable = false
WHERE health_category_id = 6;
