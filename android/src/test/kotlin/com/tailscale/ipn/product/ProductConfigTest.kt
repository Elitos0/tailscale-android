// Copyright (c) Tailscale Inc & AUTHORS
// SPDX-License-Identifier: BSD-3-Clause

package com.tailscale.ipn.product

import com.tailscale.ipn.BuildConfig
import com.tailscale.ipn.ui.util.AppVersion

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class ProductConfigTest {

  @Test
  fun defaultDebugProductConfigEqualsIntendedPublicEndpoints() {
    assertEquals("https://headscale.stardomcore.com", ProductConfig.headscaleControlUrl)
    assertEquals("https://api.stardomcore.com", ProductConfig.policyApiBaseUrl)
    assertEquals(
        "https://auth.stardomcore.com/application/o/policy-api-android-mvp/",
        ProductConfig.authentikIssuerUrl)
    assertEquals("policy-api-android-mvp", ProductConfig.policyApiOidcClientId)
    assertEquals("https://dashboard.stardomcore.com", ProductConfig.dashboardBaseUrl)

    assertTrue(
        "Headscale URL must be HTTPS",
        ProductConfig.headscaleControlUrl.startsWith("https://headscale.stardomcore.com"))
    assertTrue(
        "Policy API URL must be HTTPS",
        ProductConfig.policyApiBaseUrl.startsWith("https://api.stardomcore.com"))
    assertTrue(
        "Authentik Issuer URL must be HTTPS",
        ProductConfig.authentikIssuerUrl.startsWith(
            "https://auth.stardomcore.com/application/o/policy-api-android-mvp/"))
    assertTrue(
        "Dashboard URL must be HTTPS",
        ProductConfig.dashboardBaseUrl.startsWith("https://dashboard.stardomcore.com"))
  }

  @Test
  fun buildConfigVersionFieldsAreValidAndPositive() {
    assertTrue("BuildConfig.VERSION_CODE must be positive", BuildConfig.VERSION_CODE > 0)
    assertTrue("BuildConfig.VERSION_NAME must not be blank", BuildConfig.VERSION_NAME.isNotBlank())
    assertTrue("AppVersion.Short() must not be blank", AppVersion.Short().isNotBlank())
  }
}
