package com.portfolio.projects.Repository;

import com.portfolio.projects.entity.Project;
import org.apache.catalina.LifecycleState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

    @Query("""
            SELECT p FROM Project p
            WHERE p.deletedAt IS NULL
            ORDER BY p.updatedAt DESC
            """)
    List<Project> findAllAccessibleByUser(@Param("userId") Long userId);

    @Query("""
            SELECT p from Project p
            WHERE p.id = :projectId
                AND p.deletedAt IS NULL
            """)
    Optional<Project> findAccessibleProjectById(@Param("projectId") Long ProjectId,
                                                @Param("userId") Long userId);
}
