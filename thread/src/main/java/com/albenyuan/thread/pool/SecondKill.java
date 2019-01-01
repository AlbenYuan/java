package com.albenyuan.thread.pool;

/**
 * @Author Alben Yuan
 * @Date 2018-12-03 17:06
 */
public class SecondKill {

    private Integer userId;
    private Integer productId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SecondKill{");
        sb.append("userId=").append(userId);
        sb.append(", productId=").append(productId);
        sb.append('}');
        return sb.toString();
    }
}
