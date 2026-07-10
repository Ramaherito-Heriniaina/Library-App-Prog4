package library.app.com.repository.projection;

import java.math.BigDecimal;

public interface RevenueByCategory {
  String getCategory();

  BigDecimal getRevenue();
}
