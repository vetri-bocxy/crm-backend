package com.bocxy.crm.repository;

import com.bocxy.crm.entity.ContactCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import java.util.UUID;

public interface ContactCardRepository extends JpaRepository<ContactCard, UUID> {

    @Query(value = """
            SELECT 'overallContactCard' AS status ,COUNT(*) AS count
            FROM contact_cards
            UNION ALL
            SELECT lead_status AS status ,COUNT(*) AS count
            FROM contact_cards
            GROUP BY lead_status
            """,nativeQuery = true)
    List<Object[]> getContactCardCounts();

    @Query(value = """
    SELECT DATE_FORMAT(created_at, '%Y-%m') AS month, 
    lead_status AS status, 
    COUNT(*) AS count
    FROM contact_cards
    GROUP BY DATE_FORMAT(created_at, '%Y-%m'), lead_status
    ORDER BY month ASC
    """, nativeQuery = true)
    List<Object[]> getCountLeadStatusMonthWise();

}
