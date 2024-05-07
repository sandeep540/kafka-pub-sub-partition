package org.acme;

import java.sql.Timestamp;

public record Quote (String sku, double price, Timestamp ts) {}


