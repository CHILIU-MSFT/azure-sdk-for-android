// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.
// Changes may cause incorrect behavior and will be lost if the code is
// regenerated.

package com.azure.search.documents.indexes.models;

import com.azure.core.rest.annotation.Fluent;
import com.azure.core.serde.SerdeToPojo;
import com.azure.core.serde.SerdeProperty;

/** Represents a resource's usage and quota. */
@Fluent
public final class ResourceCounter {
    /*
     * The resource usage amount.
     */
    @SerdeProperty(value = "usage")
    private long usage;

    /*
     * The resource amount quota.
     */
    @SerdeProperty(value = "quota")
    private Long quota;

    /**
     * Creates an instance of ResourceCounter class.
     *
     * @param usage the usage value to set.
     */
    @SerdeToPojo
    public ResourceCounter(@SerdeProperty(value = "usage") long usage) {
        this.usage = usage;
    }

    /**
     * Get the usage property: The resource usage amount.
     *
     * @return the usage value.
     */
    public long getUsage() {
        return this.usage;
    }

    /**
     * Get the quota property: The resource amount quota.
     *
     * @return the quota value.
     */
    public Long getQuota() {
        return this.quota;
    }

    /**
     * Set the quota property: The resource amount quota.
     *
     * @param quota the quota value to set.
     * @return the ResourceCounter object itself.
     */
    public ResourceCounter setQuota(Long quota) {
        this.quota = quota;
        return this;
    }
}