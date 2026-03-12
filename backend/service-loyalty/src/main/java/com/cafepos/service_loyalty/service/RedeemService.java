package com.cafepos.service_loyalty.service;

import com.cafepos.service_loyalty.dto.request.RedeemRequestDTO;
import com.cafepos.service_loyalty.entity.Redeem;
import com.cafepos.service_loyalty.entity.Reward;
import com.cafepos.service_loyalty.repository.RedeemRepository;
import com.cafepos.service_loyalty.repository.RewardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RedeemService {

    @Autowired
    private RewardRepository rewardRepository;
    @Autowired
    private RedeemRepository redeemRepository;

    @Transactional // ต้องสำเร็จไปด้วยกันทั้งหมด หรือไม่ก็ไม่ต้องทำอะไรเลย
    public Redeem redeemItem(RedeemRequestDTO dto) {
        // 1. หาของรางวัล
        Reward reward = rewardRepository.findById(dto.getRewardId())
                .orElseThrow(() -> new RuntimeException("ไม่พบของรางวัล!"));

        // 2. 🌟 Business Logic: เช็คสต๊อกคงเหลือ
        if (reward.getRemain() <= 0) {
            throw new RuntimeException("ของรางวัลหมดแล้ว!");
        }

        // 3. 🌐 [จำลอง] ยิง API ไปเช็คแต้มปัจจุบันของลูกค้าที่ User Service
        int customerPoints = fetchCustomerPoints(dto.getCusId());

        // 4. 🌟 Business Logic: เช็คแต้มว่าพอแลกไหม
        if (customerPoints < reward.getRewardPoint()) {
            throw new RuntimeException("แต้มของคุณไม่พอแลกของรางวัลนี้!");
        }

        // 5. ผ่านทุกด่าน! เริ่มทำการตัดสต๊อก
        reward.setRemain(reward.getRemain() - 1);
        rewardRepository.save(reward);

        // 6. 🌐 [จำลอง] ยิง API ไปบอก User Service ให้หักแต้มลูกค้า
        deductCustomerPoints(dto.getCusId(), -reward.getRewardPoint()); // ส่งค่าติดลบไปหัก

        // 7. บันทึกประวัติการแลก
        Redeem history = new Redeem();
        history.setReward(reward);
        history.setCusId(dto.getCusId());
        history.setUsedPoint(reward.getRewardPoint());

        return redeemRepository.save(history);
    }

    private int fetchCustomerPoints(Long cusId) { return 1000; /* สมมติว่ามี 1000 แต้ม */ }
    private void deductCustomerPoints(Long cusId, Integer pointToDeduct) { /* ยิง API */ }

}
