package com.azure.data.appconfiguration.policy;

import com.azure.core.http.HttpPipelineNextPolicy;
import com.azure.core.http.policy.HttpPipelinePolicy;
import com.azure.data.appconfiguration.credentials.ConfigurationClientCredentials;

import java.io.IOException;
import java.util.Map;

import okhttp3.Request;
import okhttp3.Response;
import okio.Buffer;

public class ConfigurationCredentialsPolicy implements HttpPipelinePolicy {
    // "Host", "Date", and "x-ms-content-sha256" are required to generate "Authorization" value in
    // ConfigurationClientCredentials.

    private final ConfigurationClientCredentials credentials;

    /**
     * Creates an instance that is able to apply a {@link ConfigurationClientCredentials} credential to a request in the pipeline.
     *
     * @param credentials the credential information to authenticate to Azure App Configuration service
     */
    public ConfigurationCredentialsPolicy(ConfigurationClientCredentials credentials)  {
        this.credentials = credentials;
    }

    @Override
    public Response process(Request request, HttpPipelineNextPolicy next) throws IOException {
        Buffer buffer = new Buffer();
        if (request.body() != null) {
            request.body().writeTo(buffer);
        }
        //
        Map<String, String> authHeaders = credentials.getAuthorizationHeaders(request.url().url(), request.method(), buffer.clone());
        Request.Builder builder = request.newBuilder();
        for (Map.Entry<String, String> header : authHeaders.entrySet()) {
            builder = builder.header(header.getKey(), header.getValue());
        }
        return next.process(builder.build());
    }
}
