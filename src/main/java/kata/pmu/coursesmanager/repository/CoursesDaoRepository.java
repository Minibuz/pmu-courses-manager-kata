package kata.pmu.coursesmanager.repository;

import kata.pmu.coursesmanager.repository.dao.CourseDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface CoursesDaoRepository extends JpaRepository<CourseDao, Integer> {

    @Query("SELECT MAX(c.numero) FROM CourseDao c WHERE c.date = :date")
    Integer getLastNumberForDay(Date date);
}
