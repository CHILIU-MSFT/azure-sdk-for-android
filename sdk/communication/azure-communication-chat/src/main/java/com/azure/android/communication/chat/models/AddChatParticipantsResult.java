// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.android.communication.chat.models;

import com.azure.android.core.rest.annotation.Fluent;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/** Result of the add chat participants operation. */
@Fluent
public final class AddChatParticipantsResult {
    /*
     * The participants that failed to be added to the chat thread.
     */
    @JsonProperty(value = "invalidParticipants", access = JsonProperty.Access.WRITE_ONLY)
    private List<ChatError> invalidParticipants;

    /**
     * Get the invalidParticipants property: The participants that failed to be added to the chat thread.
     *
     * @return the invalidParticipants value.
     */
    public List<ChatError> getInvalidParticipants() {
        return this.invalidParticipants;
    }

    /**
     * Set the invalidParticipants property: The invalidParticipants property.
     *
     * @param invalidParticipants the invalidParticipants value to set.
     * @return the AddChatParticipantsResult object itself.
     */
    public AddChatParticipantsResult setInvalidParticipants(List<ChatError> invalidParticipants) {
        this.invalidParticipants = invalidParticipants;
        return this;
    }
}
