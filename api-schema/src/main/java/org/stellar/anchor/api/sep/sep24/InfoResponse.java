package org.stellar.anchor.api.sep.sep24;

import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Map;
import lombok.Data;
import org.stellar.anchor.api.sep.AssetInfo;

@Data
public class InfoResponse {
  Map<String, AssetInfo.AssetOperation> deposit = new HashMap<>();
  Map<String, AssetInfo.AssetOperation> withdraw = new HashMap<>();
  FeeResponse fee = new FeeResponse();

  @SerializedName("features")
  FeatureFlagResponse featureFlags = new FeatureFlagResponse(false, false);

  @SuppressWarnings("unused")
  @Data
  public static class FeeResponse {
    final Boolean enabled;

    public FeeResponse() {
      this.enabled = true;
    }
  }

  @Data
  public static class FeatureFlagResponse {
    @SerializedName("account_creation")
    Boolean accountCreation;

    @SerializedName("claimable_balances")
    Boolean claimableBalances;

    public FeatureFlagResponse() {
      this.accountCreation = true;
      this.claimableBalances = true;
    }

    public FeatureFlagResponse(boolean accountCreation, boolean claimableBalances) {
      this.accountCreation = accountCreation;
      this.claimableBalances = claimableBalances;
    }
  }
}
