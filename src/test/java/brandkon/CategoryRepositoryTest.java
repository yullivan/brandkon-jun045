package brandkon;

import brandkon.Category.Category;
import brandkon.Category.CategoryRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Id;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
public class CategoryRepositoryTest {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    EntityManager em;    //entitymanager - 객체를 자동으로 주입받아 사용할 수 있게 함,
                        // JPA에서 데이터베이스와의 상호작용을 처리하는 핵심 인터페이스


    //엔티티 오브젝트를 저장하여 SQL 쿼리(INSERT)가 실행될 때
    // created_at과 updated_at 컬럼에 현재 시각을 저장하는지
    @Test
    void 저장시_현재시각으로_필드_채워지는지_확인() {
        Category category = new Category("카페", "cafe", "");   // category 객체는 아직 저장되지 않았기 때문에 id, createdAt, updatedAt 필드는 초기화되지 않은 상태
        assertThat(category.getId()).isNull();  //id는 자동 생성되는 값이기 때문에, 아직 null
        assertThat(category.getCreatedAt()).isNotNull();
        assertThat(category.getUpdatedAt()).isNotNull();  //저장될 때 자동으로 채워지기 전까지 null

        categoryRepository.save(category);

        assertThat(category.getId()).isNotNull();
        assertThat(category.getCreatedAt()).isNotNull();
        assertThat(category.getUpdatedAt()).isNotNull();
    }

    //엔티티 오브젝트를 수정하여 SQL 쿼리(UPDATE)가 실행될 때
    // updated_at 컬럼의 값이 수정 시각으로 바뀌는지 확인
    @Test
    void lastModifiedDateTest() {
        Category category = new Category("카페1","cafe1","");
        categoryRepository.save(category);

        LocalDateTime 기존수정일시 = category.getUpdatedAt();

        assertThat(category.getId()).isNotNull();
        assertThat(category.getCreatedAt()).isNotNull();
        assertThat(category.getUpdatedAt()).isNotNull();

        category.setName("카페수정");
        category.setSlug("update");
        category.setSlug("");

        // 오브젝트 수정 후 아래 코드 실행
        em.flush();   //변경된 엔티티들을 DB에 반영하도록 강제하는 메서드

        assertThat(기존수정일시).isNotEqualTo(category.getUpdatedAt());



    }
}
