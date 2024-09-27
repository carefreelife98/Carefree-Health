use carefree_health_test;
ALTER TABLE physical_category AUTO_INCREMENT = 1; -- 테이블 내 모든 데이터 초기화 후 실행 가능

-- ================= 예시 ================= --
-- 1. 카테고리에 새로운 항목 추가
INSERT INTO physical_category (category_name) VALUES ('피지컬 트레이닝');

-- 2. 클로저 테이블에 상위-하위 관계 삽입 (하위 카테고리 추가 시)
INSERT INTO physical_category_closure (parent_cat_id, sub_cat_id, depth)
SELECT sub_cat_id, LAST_INSERT_ID(), depth + 1
FROM physical_category_closure
WHERE sub_cat_id = 7;  -- 대상 카테고리의 상위 카테고리의 ID

-- 2. 클로저 테이블에 상위-하위 관계 삽입 (최상위 카테고리 추가 시)
INSERT INTO physical_category_closure (parent_cat_id, sub_cat_id, depth)
VALUES (LAST_INSERT_ID(), LAST_INSERT_ID(), 0);






-- ====================== Data Insertion ====================== --
use carefree_health_test;
ALTER TABLE physical_category AUTO_INCREMENT = 1; -- 테이블 내 AUTO_INCREMENT 값 초기화 테이블 내 모든 데이터 초기화 후 실행 가능.
-- INSERT INTO physical_category_closure (parent_cat_id, sub_cat_id, depth) VALUES (LAST_INSERT_ID(), LAST_INSERT_ID(), 0); : 클로저 테이블 사용 시 항상 자기 자신과의 관계가 존재해야 정상 계층화 가능.

-- 상위 카테고리 (근력, 유산소, 유연성, 지구력) 추가
INSERT INTO physical_category (category_name) VALUES ('STRENGTH');
INSERT INTO physical_category_closure (parent_cat_id, sub_cat_id, depth)
VALUES (LAST_INSERT_ID(), LAST_INSERT_ID(), 0);

INSERT INTO physical_category (category_name) VALUES ('CARDIO');
INSERT INTO physical_category_closure (parent_cat_id, sub_cat_id, depth)
VALUES (LAST_INSERT_ID(), LAST_INSERT_ID(), 0);

INSERT INTO physical_category (category_name) VALUES ('FLEX');
INSERT INTO physical_category_closure (parent_cat_id, sub_cat_id, depth)
VALUES (LAST_INSERT_ID(), LAST_INSERT_ID(), 0);

INSERT INTO physical_category (category_name) VALUES ('ENDURE');
INSERT INTO physical_category_closure (parent_cat_id, sub_cat_id, depth)
VALUES (LAST_INSERT_ID(), LAST_INSERT_ID(), 0);



-- 중위 카테고리 추가 (e.g. STR_TOP: 상체, STR_BOTTOM: 하체, STR_CORE: 코어)
INSERT INTO physical_category (category_name) VALUES ('STR_TOP');
INSERT INTO physical_category_closure (parent_cat_id, sub_cat_id, depth)
VALUES (LAST_INSERT_ID(), LAST_INSERT_ID(), 0);
INSERT INTO physical_category_closure (parent_cat_id, sub_cat_id, depth)
SELECT sub_cat_id, LAST_INSERT_ID(), depth + 1
FROM physical_category_closure
WHERE sub_cat_id = 1;

INSERT INTO physical_category (category_name) VALUES ('STR_BOTTOM');
INSERT INTO physical_category_closure (parent_cat_id, sub_cat_id, depth)
VALUES (LAST_INSERT_ID(), LAST_INSERT_ID(), 0);
INSERT INTO physical_category_closure (parent_cat_id, sub_cat_id, depth)
SELECT sub_cat_id, LAST_INSERT_ID(), depth + 1
FROM physical_category_closure
WHERE sub_cat_id = 1;

INSERT INTO physical_category (category_name) VALUES ('STR_CORE');
INSERT INTO physical_category_closure (parent_cat_id, sub_cat_id, depth)
VALUES (LAST_INSERT_ID(), LAST_INSERT_ID(), 0);
INSERT INTO physical_category_closure (parent_cat_id, sub_cat_id, depth)
SELECT sub_cat_id, LAST_INSERT_ID(), depth + 1
FROM physical_category_closure
WHERE sub_cat_id = 1;



-- 하위 카테고리 추가 (자기 자신과의 관계를 꼭 먼저 추가해주어야 정상 계층화 가능 !!)
INSERT INTO physical_category (category_name) VALUES ('STR_TOP_SHOULDER');
INSERT INTO physical_category_closure (parent_cat_id, sub_cat_id, depth)
VALUES (LAST_INSERT_ID(), LAST_INSERT_ID(), 0);
INSERT INTO physical_category_closure (parent_cat_id, sub_cat_id, depth)
SELECT parent_cat_id, LAST_INSERT_ID(), depth + 1
FROM physical_category_closure
WHERE sub_cat_id = 5;

INSERT INTO physical_category (category_name) VALUES ('STR_TOP_CHEST');
INSERT INTO physical_category_closure (parent_cat_id, sub_cat_id, depth)
VALUES (LAST_INSERT_ID(), LAST_INSERT_ID(), 0);
INSERT INTO physical_category_closure (parent_cat_id, sub_cat_id, depth)
SELECT parent_cat_id, LAST_INSERT_ID(), depth + 1
FROM physical_category_closure
WHERE sub_cat_id = 5;

INSERT INTO physical_category (category_name) VALUES ('STR_TOP_BACK');
INSERT INTO physical_category_closure (parent_cat_id, sub_cat_id, depth)
VALUES (LAST_INSERT_ID(), LAST_INSERT_ID(), 0);
INSERT INTO physical_category_closure (parent_cat_id, sub_cat_id, depth)
SELECT parent_cat_id, LAST_INSERT_ID(), depth + 1
FROM physical_category_closure
WHERE sub_cat_id = 5;

INSERT INTO physical_category (category_name) VALUES ('STR_TOP_BICEPS');
INSERT INTO physical_category_closure (parent_cat_id, sub_cat_id, depth)
VALUES (LAST_INSERT_ID(), LAST_INSERT_ID(), 0);
INSERT INTO physical_category_closure (parent_cat_id, sub_cat_id, depth)
SELECT parent_cat_id, LAST_INSERT_ID(), depth + 1
FROM physical_category_closure
WHERE sub_cat_id = 5;

INSERT INTO physical_category (category_name) VALUES ('STR_TOP_TRICEPS');
INSERT INTO physical_category_closure (parent_cat_id, sub_cat_id, depth)
VALUES (LAST_INSERT_ID(), LAST_INSERT_ID(), 0);
INSERT INTO physical_category_closure (parent_cat_id, sub_cat_id, depth)
SELECT parent_cat_id, LAST_INSERT_ID(), depth + 1
FROM physical_category_closure
WHERE sub_cat_id = 5;



-- ====================== data generate ====================== -- 