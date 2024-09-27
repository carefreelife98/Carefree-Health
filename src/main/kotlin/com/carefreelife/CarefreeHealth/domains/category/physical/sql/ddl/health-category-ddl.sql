use carefree_health_test;

# 카테고리 테이블 생성
CREATE TABLE health_category (
    health_category_id INT PRIMARY KEY AUTO_INCREMENT,
    category_name      VARCHAR(30) NOT NULL,
    usable             BOOLEAN NOT NULL DEFAULT TRUE
);

ALTER TABLE health_category
    ADD COLUMN usable BOOLEAN NOT NULL DEFAULT TRUE;



# 카테고리 클로저 테이블 생성
CREATE TABLE health_category_closure (
     parent_cat_id INT, -- 상위 카테고리
     sub_cat_id INT, -- 하위 카테고리
     depth INT, -- 상위-하위 관계의 깊이 (0일 경우 자기 자신)
     PRIMARY KEY (parent_cat_id, sub_cat_id),
     FOREIGN KEY (parent_cat_id) REFERENCES health_category(health_category_id),
     FOREIGN KEY (sub_cat_id) REFERENCES health_category(health_category_id)
);