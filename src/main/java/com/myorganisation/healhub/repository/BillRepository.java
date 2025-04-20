package com.myorganisation.healhub.repository;

import com.myorganisation.healhub.entity.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillRepository extends JpaRepository<Bill, Long> {
}
