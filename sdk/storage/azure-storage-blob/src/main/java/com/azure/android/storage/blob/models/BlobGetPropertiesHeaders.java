// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.android.storage.blob.models;

import com.azure.android.core.annotation.HeaderCollection;
import com.azure.android.core.util.CoreUtil;
import com.azure.android.core.util.DateTimeRfc1123;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import org.threeten.bp.OffsetDateTime;

import java.util.Map;

/**
 * Defines headers for GetProperties operation.
 */
@JacksonXmlRootElement(localName = "Blob-GetProperties-Headers")
public final class BlobGetPropertiesHeaders {
    /**
     * Returns the date and time the blob was last modified. Any operation that
     * modifies the blob, including an update of the blob's metadata or
     * properties, changes the last-modified time of the blob.
     */
    @JsonProperty(value = "Last-Modified")
    private DateTimeRfc1123 lastModified;

    /**
     * Returns the date and time the blob was created.
     */
    @JsonProperty(value = "x-ms-creation-time")
    private DateTimeRfc1123 creationTime;

    /**
     * The metadata property.
     */
    @HeaderCollection("x-ms-meta-")
    private Map<String, String> metadata;

    /**
     * The blob's type. Possible values include: 'BlockBlob', 'PageBlob',
     * 'AppendBlob'
     */
    @JsonProperty(value = "x-ms-blob-type")
    private BlobType blobType;

    /**
     * Conclusion time of the last attempted Copy Blob operation where this
     * blob was the destination blob. This value can specify the time of a
     * completed, aborted, or failed copy attempt. This header does not appear
     * if a copy is pending, if this blob has never been the destination in a
     * Copy Blob operation, or if this blob has been modified after a concluded
     * Copy Blob operation using Set Blob Properties, Put Blob, or Put Block
     * List.
     */
    @JsonProperty(value = "x-ms-copy-completion-time")
    private DateTimeRfc1123 copyCompletionTime;

    /**
     * Only appears when x-ms-copy-status is failed or pending. Describes the
     * cause of the last fatal or non-fatal copy operation failure. This header
     * does not appear if this blob has never been the destination in a Copy
     * Blob operation, or if this blob has been modified after a concluded Copy
     * Blob operation using Set Blob Properties, Put Blob, or Put Block List
     */
    @JsonProperty(value = "x-ms-copy-status-description")
    private String copyStatusDescription;

    /**
     * String identifier for this copy operation. Use with Get Blob Properties
     * to check the status of this copy operation, or pass to Abort Copy Blob
     * to abort a pending copy.
     */
    @JsonProperty(value = "x-ms-copy-id")
    private String copyId;

    /**
     * Contains the number of bytes copied and the total bytes in the source in
     * the last attempted Copy Blob operation where this blob was the
     * destination blob. Can show between 0 and Content-Length bytes copied.
     * This header does not appear if this blob has never been the destination
     * in a Copy Blob operation, or if this blob has been modified after a
     * concluded Copy Blob operation using Set Blob Properties, Put Blob, or
     * Put Block List
     */
    @JsonProperty(value = "x-ms-copy-progress")
    private String copyProgress;

    /**
     * URL up to 2 KB in length that specifies the source blob or file used in
     * the last attempted Copy Blob operation where this blob was the
     * destination blob. This header does not appear if this blob has never
     * been the destination in a Copy Blob operation, or if this blob has been
     * modified after a concluded Copy Blob operation using Set Blob
     * Properties, Put Blob, or Put Block List.
     */
    @JsonProperty(value = "x-ms-copy-source")
    private String copySource;

    /**
     * State of the copy operation identified by x-ms-copy-id. Possible values
     * include: 'pending', 'success', 'aborted', 'failed'
     */
    @JsonProperty(value = "x-ms-copy-status")
    private CopyStatusType copyStatus;

    /**
     * Included if the blob is incremental copy blob.
     */
    @JsonProperty(value = "x-ms-incremental-copy")
    private Boolean isIncrementalCopy;

    /**
     * Included if the blob is incremental copy blob or incremental copy
     * snapshot, if x-ms-copy-status is success. Snapshot time of the last
     * successful incremental copy snapshot for this blob.
     */
    @JsonProperty(value = "x-ms-copy-destination-snapshot")
    private String destinationSnapshot;

    /**
     * When a blob is leased, specifies whether the lease is of infinite or
     * fixed duration. Possible values include: 'infinite', 'fixed'
     */
    @JsonProperty(value = "x-ms-lease-duration")
    private LeaseDurationType leaseDuration;

    /**
     * Lease state of the blob. Possible values include: 'available', 'leased',
     * 'expired', 'breaking', 'broken'
     */
    @JsonProperty(value = "x-ms-lease-state")
    private LeaseStateType leaseState;

    /**
     * The current lease status of the blob. Possible values include: 'locked',
     * 'unlocked'
     */
    @JsonProperty(value = "x-ms-lease-status")
    private LeaseStatusType leaseStatus;

    /**
     * The number of bytes present in the response body.
     */
    @JsonProperty(value = "Content-Length")
    private Long contentLength;

    /**
     * The content type specified for the blob. The default content type is
     * 'application/octet-stream'
     */
    @JsonProperty(value = "Content-Type")
    private String contentType;

    /**
     * The ETag contains a value that you can use to perform operations
     * conditionally. If the request version is 2011-08-18 or newer, the ETag
     * value will be in quotes.
     */
    @JsonProperty(value = "ETag")
    private String eTag;

    /**
     * If the blob has an MD5 hash and this operation is to read the full blob,
     * this response header is returned so that the client can check for
     * message content integrity.
     */
    @JsonProperty(value = "Content-MD5")
    private byte[] contentMD5;

    /**
     * This header returns the value that was specified for the
     * Content-Encoding request header
     */
    @JsonProperty(value = "Content-Encoding")
    private String contentEncoding;

    /**
     * This header returns the value that was specified for the
     * 'x-ms-blob-content-disposition' header. The Content-Disposition response
     * header field conveys additional information about how to process the
     * response payload, and also can be used to attach additional metadata.
     * For example, if set to attachment, it indicates that the user-agent
     * should not display the response, but instead show a Save As dialog with
     * a filename other than the blob name specified.
     */
    @JsonProperty(value = "Content-Disposition")
    private String contentDisposition;

    /**
     * This header returns the value that was specified for the
     * Content-Language request header.
     */
    @JsonProperty(value = "Content-Language")
    private String contentLanguage;

    /**
     * This header is returned if it was previously specified for the blob.
     */
    @JsonProperty(value = "Cache-Control")
    private String cacheControl;

    /**
     * The current sequence number for a page blob. This header is not returned
     * for block blobs or append blobs
     */
    @JsonProperty(value = "x-ms-blob-sequence-number")
    private Long blobSequenceNumber;

    /**
     * If a client request id header is sent in the request, this header will
     * be present in the response with the same value.
     */
    @JsonProperty(value = "x-ms-client-request-id")
    private String clientRequestId;

    /**
     * This header uniquely identifies the request that was made and can be
     * used for troubleshooting the request.
     */
    @JsonProperty(value = "x-ms-request-id")
    private String requestId;

    /**
     * Indicates the version of the Blob service used to execute the request.
     * This header is returned for requests made against version 2009-09-19 and
     * above.
     */
    @JsonProperty(value = "x-ms-version")
    private String version;

    /**
     * UTC date/time value generated by the service that indicates the time at
     * which the response was initiated
     */
    @JsonProperty(value = "Date")
    private DateTimeRfc1123 dateProperty;

    /**
     * Indicates that the service supports requests for partial blob content.
     */
    @JsonProperty(value = "Accept-Ranges")
    private String acceptRanges;

    /**
     * The number of committed blocks present in the blob. This header is
     * returned only for append blobs.
     */
    @JsonProperty(value = "x-ms-blob-committed-block-count")
    private Integer blobCommittedBlockCount;

    /**
     * The value of this header is set to true if the blob data and application
     * metadata are completely encrypted using the specified algorithm.
     * Otherwise, the value is set to false (when the blob is unencrypted, or
     * if only parts of the blob/application metadata are encrypted).
     */
    @JsonProperty(value = "x-ms-server-encrypted")
    private Boolean isServerEncrypted;

    /**
     * The SHA-256 hash of the encryption key used to encrypt the metadata.
     * This header is only returned when the metadata was encrypted with a
     * customer-provided key.
     */
    @JsonProperty(value = "x-ms-encryption-key-sha256")
    private String encryptionKeySha256;

    /**
     * Returns the name of the encryption scope used to encrypt the blob
     * contents and application metadata.  Note that the absence of this header
     * implies use of the default account encryption scope.
     */
    @JsonProperty(value = "x-ms-encryption-scope")
    private String encryptionScope;

    /**
     * The tier of page blob on a premium storage account or tier of block blob
     * on blob storage LRS accounts. For a list of allowed premium page blob
     * tiers, see
     * https://docs.microsoft.com/en-us/azure/virtual-machines/windows/premium-storage#features.
     * For blob storage LRS accounts, valid values are Hot/Cool/Archive.
     */
    @JsonProperty(value = "x-ms-access-tier")
    private String accessTier;

    /**
     * For page blobs on a premium storage account only. If the access tier is
     * not explicitly set on the blob, the tier is inferred based on its
     * content length and this header will be returned with true value.
     */
    @JsonProperty(value = "x-ms-access-tier-inferred")
    private Boolean accessTierInferred;

    /**
     * For blob storage LRS accounts, valid values are
     * rehydrate-pending-to-hot/rehydrate-pending-to-cool. If the blob is being
     * rehydrated and is not complete then this header is returned indicating
     * that rehydrate is pending and also tells the destination tier.
     */
    @JsonProperty(value = "x-ms-archive-status")
    private String archiveStatus;

    /**
     * The time the tier was changed on the object. This is only returned if
     * the tier on the block blob was ever set.
     */
    @JsonProperty(value = "x-ms-access-tier-change-time")
    private DateTimeRfc1123 accessTierChangeTime;

    /**
     * The errorCode property.
     */
    @JsonProperty(value = "x-ms-error-code")
    private String errorCode;

    /***
     * Get the lastModified property: Returns the date and time the blob was
     * last modified. Any operation that modifies the blob, including an update
     * of the blob's metadata or properties, changes the last-modified time of
     * the blob.
     *
     * @return the lastModified value.
     */
    public OffsetDateTime getLastModified() {
        if (this.lastModified == null) {
            return null;
        }
        return this.lastModified.getDateTime();
    }

    /***
     * Set the lastModified property: Returns the date and time the blob was
     * last modified. Any operation that modifies the blob, including an update
     * of the blob's metadata or properties, changes the last-modified time of
     * the blob.
     *
     * @param lastModified the lastModified value to set.
     * @return the BlobGetPropertiesHeaders object itself.
     */
    public BlobGetPropertiesHeaders setLastModified(OffsetDateTime lastModified) {
        if (lastModified == null) {
            this.lastModified = null;
        } else {
            this.lastModified = new DateTimeRfc1123(lastModified);
        }
        return this;
    }

    /***
     * Get the creationTime property: Returns the date and time the blob was
     * created.
     *
     * @return the creationTime value.
     */
    public OffsetDateTime getCreationTime() {
        if (this.creationTime == null) {
            return null;
        }
        return this.creationTime.getDateTime();
    }

    /***
     * Set the creationTime property: Returns the date and time the blob was
     * created.
     *
     * @param creationTime the creationTime value to set.
     * @return the BlobGetPropertiesHeaders object itself.
     */
    public BlobGetPropertiesHeaders setCreationTime(OffsetDateTime creationTime) {
        if (creationTime == null) {
            this.creationTime = null;
        } else {
            this.creationTime = new DateTimeRfc1123(creationTime);
        }
        return this;
    }

    /***
     * Get the metadata property: The metadata property.
     *
     * @return the metadata value.
     */
    public Map<String, String> getMetadata() {
        return this.metadata;
    }

    /***
     * Set the metadata property: The metadata property.
     *
     * @param metadata the metadata value to set.
     * @return the BlobGetPropertiesHeaders object itself.
     */
    public BlobGetPropertiesHeaders setMetadata(Map<String, String> metadata) {
        this.metadata = metadata;
        return this;
    }

    /***
     * Get the blobType property: The blob's type. Possible values include:
     * 'BlockBlob', 'PageBlob', 'AppendBlob'.
     *
     * @return the blobType value.
     */
    public BlobType getBlobType() {
        return this.blobType;
    }

    /***
     * Set the blobType property: The blob's type. Possible values include:
     * 'BlockBlob', 'PageBlob', 'AppendBlob'.
     *
     * @param blobType the blobType value to set.
     * @return the BlobGetPropertiesHeaders object itself.
     */
    public BlobGetPropertiesHeaders setBlobType(BlobType blobType) {
        this.blobType = blobType;
        return this;
    }

    /***
     * Get the copyCompletionTime property: Conclusion time of the last
     * attempted Copy Blob operation where this blob was the destination blob.
     * This value can specify the time of a completed, aborted, or failed copy
     * attempt. This header does not appear if a copy is pending, if this blob
     * has never been the destination in a Copy Blob operation, or if this blob
     * has been modified after a concluded Copy Blob operation using Set Blob
     * Properties, Put Blob, or Put Block List.
     *
     * @return the copyCompletionTime value.
     */
    public OffsetDateTime getCopyCompletionTime() {
        if (this.copyCompletionTime == null) {
            return null;
        }
        return this.copyCompletionTime.getDateTime();
    }

    /***
     * Set the copyCompletionTime property: Conclusion time of the last
     * attempted Copy Blob operation where this blob was the destination blob.
     * This value can specify the time of a completed, aborted, or failed copy
     * attempt. This header does not appear if a copy is pending, if this blob
     * has never been the destination in a Copy Blob operation, or if this blob
     * has been modified after a concluded Copy Blob operation using Set Blob
     * Properties, Put Blob, or Put Block List.
     *
     * @param copyCompletionTime the copyCompletionTime value to set.
     * @return the BlobGetPropertiesHeaders object itself.
     */
    public BlobGetPropertiesHeaders setCopyCompletionTime(OffsetDateTime copyCompletionTime) {
        if (copyCompletionTime == null) {
            this.copyCompletionTime = null;
        } else {
            this.copyCompletionTime = new DateTimeRfc1123(copyCompletionTime);
        }
        return this;
    }

    /***
     * Get the copyStatusDescription property: Only appears when
     * x-ms-copy-status is failed or pending. Describes the cause of the last
     * fatal or non-fatal copy operation failure. This header does not appear
     * if this blob has never been the destination in a Copy Blob operation, or
     * if this blob has been modified after a concluded Copy Blob operation
     * using Set Blob Properties, Put Blob, or Put Block List.
     *
     * @return the copyStatusDescription value.
     */
    public String getCopyStatusDescription() {
        return this.copyStatusDescription;
    }

    /***
     * Set the copyStatusDescription property: Only appears when
     * x-ms-copy-status is failed or pending. Describes the cause of the last
     * fatal or non-fatal copy operation failure. This header does not appear
     * if this blob has never been the destination in a Copy Blob operation, or
     * if this blob has been modified after a concluded Copy Blob operation
     * using Set Blob Properties, Put Blob, or Put Block List.
     *
     * @param copyStatusDescription the copyStatusDescription value to set.
     * @return the BlobGetPropertiesHeaders object itself.
     */
    public BlobGetPropertiesHeaders setCopyStatusDescription(String copyStatusDescription) {
        this.copyStatusDescription = copyStatusDescription;
        return this;
    }

    /***
     * Get the copyId property: String identifier for this copy operation. Use
     * with Get Blob Properties to check the status of this copy operation, or
     * pass to Abort Copy Blob to abort a pending copy.
     *
     * @return the copyId value.
     */
    public String getCopyId() {
        return this.copyId;
    }

    /***
     * Set the copyId property: String identifier for this copy operation. Use
     * with Get Blob Properties to check the status of this copy operation, or
     * pass to Abort Copy Blob to abort a pending copy.
     *
     * @param copyId the copyId value to set.
     * @return the BlobGetPropertiesHeaders object itself.
     */
    public BlobGetPropertiesHeaders setCopyId(String copyId) {
        this.copyId = copyId;
        return this;
    }

    /***
     * Get the copyProgress property: Contains the number of bytes copied and
     * the total bytes in the source in the last attempted Copy Blob operation
     * where this blob was the destination blob. Can show between 0 and
     * Content-Length bytes copied. This header does not appear if this blob
     * has never been the destination in a Copy Blob operation, or if this blob
     * has been modified after a concluded Copy Blob operation using Set Blob
     * Properties, Put Blob, or Put Block List.
     *
     * @return the copyProgress value.
     */
    public String getCopyProgress() {
        return this.copyProgress;
    }

    /***
     * Set the copyProgress property: Contains the number of bytes copied and
     * the total bytes in the source in the last attempted Copy Blob operation
     * where this blob was the destination blob. Can show between 0 and
     * Content-Length bytes copied. This header does not appear if this blob
     * has never been the destination in a Copy Blob operation, or if this blob
     * has been modified after a concluded Copy Blob operation using Set Blob
     * Properties, Put Blob, or Put Block List.
     *
     * @param copyProgress the copyProgress value to set.
     * @return the BlobGetPropertiesHeaders object itself.
     */
    public BlobGetPropertiesHeaders setCopyProgress(String copyProgress) {
        this.copyProgress = copyProgress;
        return this;
    }

    /***
     * Get the copySource property: URL up to 2 KB in length that specifies the
     * source blob or file used in the last attempted Copy Blob operation where
     * this blob was the destination blob. This header does not appear if this
     * blob has never been the destination in a Copy Blob operation, or if this
     * blob has been modified after a concluded Copy Blob operation using Set
     * Blob Properties, Put Blob, or Put Block List.
     *
     * @return the copySource value.
     */
    public String getCopySource() {
        return this.copySource;
    }

    /***
     * Set the copySource property: URL up to 2 KB in length that specifies the
     * source blob or file used in the last attempted Copy Blob operation where
     * this blob was the destination blob. This header does not appear if this
     * blob has never been the destination in a Copy Blob operation, or if this
     * blob has been modified after a concluded Copy Blob operation using Set
     * Blob Properties, Put Blob, or Put Block List.
     *
     * @param copySource the copySource value to set.
     * @return the BlobGetPropertiesHeaders object itself.
     */
    public BlobGetPropertiesHeaders setCopySource(String copySource) {
        this.copySource = copySource;
        return this;
    }

    /***
     * Get the copyStatus property: State of the copy operation identified by
     * x-ms-copy-id. Possible values include: 'pending', 'success', 'aborted',
     * 'failed'.
     *
     * @return the copyStatus value.
     */
    public CopyStatusType getCopyStatus() {
        return this.copyStatus;
    }

    /***
     * Set the copyStatus property: State of the copy operation identified by
     * x-ms-copy-id. Possible values include: 'pending', 'success', 'aborted',
     * 'failed'.
     *
     * @param copyStatus the copyStatus value to set.
     * @return the BlobGetPropertiesHeaders object itself.
     */
    public BlobGetPropertiesHeaders setCopyStatus(CopyStatusType copyStatus) {
        this.copyStatus = copyStatus;
        return this;
    }

    /***
     * Get the isIncrementalCopy property: Included if the blob is incremental
     * copy blob.
     *
     * @return the isIncrementalCopy value.
     */
    public Boolean isIncrementalCopy() {
        return this.isIncrementalCopy;
    }

    /***
     * Set the isIncrementalCopy property: Included if the blob is incremental
     * copy blob.
     *
     * @param isIncrementalCopy the isIncrementalCopy value to set.
     * @return the BlobGetPropertiesHeaders object itself.
     */
    public BlobGetPropertiesHeaders setIsIncrementalCopy(Boolean isIncrementalCopy) {
        this.isIncrementalCopy = isIncrementalCopy;
        return this;
    }

    /***
     * Get the destinationSnapshot property: Included if the blob is
     * incremental copy blob or incremental copy snapshot, if x-ms-copy-status
     * is success. Snapshot time of the last successful incremental copy
     * snapshot for this blob.
     *
     * @return the destinationSnapshot value.
     */
    public String getDestinationSnapshot() {
        return this.destinationSnapshot;
    }

    /***
     * Set the destinationSnapshot property: Included if the blob is
     * incremental copy blob or incremental copy snapshot, if x-ms-copy-status
     * is success. Snapshot time of the last successful incremental copy
     * snapshot for this blob.
     *
     * @param destinationSnapshot the destinationSnapshot value to set.
     * @return the BlobGetPropertiesHeaders object itself.
     */
    public BlobGetPropertiesHeaders setDestinationSnapshot(String destinationSnapshot) {
        this.destinationSnapshot = destinationSnapshot;
        return this;
    }

    /***
     * Get the leaseDuration property: When a blob is leased, specifies whether
     * the lease is of infinite or fixed duration. Possible values include:
     * 'infinite', 'fixed'.
     *
     * @return the leaseDuration value.
     */
    public LeaseDurationType getLeaseDuration() {
        return this.leaseDuration;
    }

    /***
     * Set the leaseDuration property: When a blob is leased, specifies whether
     * the lease is of infinite or fixed duration. Possible values include:
     * 'infinite', 'fixed'.
     *
     * @param leaseDuration the leaseDuration value to set.
     * @return the BlobGetPropertiesHeaders object itself.
     */
    public BlobGetPropertiesHeaders setLeaseDuration(LeaseDurationType leaseDuration) {
        this.leaseDuration = leaseDuration;
        return this;
    }

    /***
     * Get the leaseState property: Lease state of the blob. Possible values
     * include: 'available', 'leased', 'expired', 'breaking', 'broken'.
     *
     * @return the leaseState value.
     */
    public LeaseStateType getLeaseState() {
        return this.leaseState;
    }

    /***
     * Set the leaseState property: Lease state of the blob. Possible values
     * include: 'available', 'leased', 'expired', 'breaking', 'broken'.
     *
     * @param leaseState the leaseState value to set.
     * @return the BlobGetPropertiesHeaders object itself.
     */
    public BlobGetPropertiesHeaders setLeaseState(LeaseStateType leaseState) {
        this.leaseState = leaseState;
        return this;
    }

    /***
     * Get the leaseStatus property: The current lease status of the blob.
     * Possible values include: 'locked', 'unlocked'.
     *
     * @return the leaseStatus value.
     */
    public LeaseStatusType getLeaseStatus() {
        return this.leaseStatus;
    }

    /***
     * Set the leaseStatus property: The current lease status of the blob.
     * Possible values include: 'locked', 'unlocked'.
     *
     * @param leaseStatus the leaseStatus value to set.
     * @return the BlobGetPropertiesHeaders object itself.
     */
    public BlobGetPropertiesHeaders setLeaseStatus(LeaseStatusType leaseStatus) {
        this.leaseStatus = leaseStatus;
        return this;
    }

    /***
     * Get the contentLength property: The number of bytes present in the
     * response body.
     *
     * @return the contentLength value.
     */
    public Long getContentLength() {
        return this.contentLength;
    }

    /***
     * Set the contentLength property: The number of bytes present in the
     * response body.
     *
     * @param contentLength the contentLength value to set.
     * @return the BlobGetPropertiesHeaders object itself.
     */
    public BlobGetPropertiesHeaders setContentLength(Long contentLength) {
        this.contentLength = contentLength;
        return this;
    }

    /***
     * Get the contentType property: The content type specified for the blob.
     * The default content type is 'application/octet-stream'.
     *
     * @return the contentType value.
     */
    public String getContentType() {
        return this.contentType;
    }

    /***
     * Set the contentType property: The content type specified for the blob.
     * The default content type is 'application/octet-stream'.
     *
     * @param contentType the contentType value to set.
     * @return the BlobGetPropertiesHeaders object itself.
     */
    public BlobGetPropertiesHeaders setContentType(String contentType) {
        this.contentType = contentType;
        return this;
    }

    /***
     * Get the eTag property: The ETag contains a value that you can use to
     * perform operations conditionally. If the request version is 2011-08-18
     * or newer, the ETag value will be in quotes.
     *
     * @return the eTag value.
     */
    public String getETag() {
        return this.eTag;
    }

    /***
     * Set the eTag property: The ETag contains a value that you can use to
     * perform operations conditionally. If the request version is 2011-08-18
     * or newer, the ETag value will be in quotes.
     *
     * @param eTag the eTag value to set.
     * @return the BlobGetPropertiesHeaders object itself.
     */
    public BlobGetPropertiesHeaders setETag(String eTag) {
        this.eTag = eTag;
        return this;
    }

    /***
     * Get the contentMD5 property: If the blob has an MD5 hash and this
     * operation is to read the full blob, this response header is returned so
     * that the client can check for message content integrity.
     *
     * @return the contentMD5 value.
     */
    public byte[] getContentMD5() {
        return CoreUtil.clone(this.contentMD5);
    }

    /***
     * Set the contentMD5 property: If the blob has an MD5 hash and this
     * operation is to read the full blob, this response header is returned so
     * that the client can check for message content integrity.
     *
     * @param contentMD5 the contentMD5 value to set.
     * @return the BlobGetPropertiesHeaders object itself.
     */
    public BlobGetPropertiesHeaders setContentMD5(byte[] contentMD5) {
        this.contentMD5 = CoreUtil.clone(contentMD5);
        return this;
    }

    /***
     * Get the contentEncoding property: This header returns the value that was
     * specified for the Content-Encoding request header.
     *
     * @return the contentEncoding value.
     */
    public String getContentEncoding() {
        return this.contentEncoding;
    }

    /***
     * Set the contentEncoding property: This header returns the value that was
     * specified for the Content-Encoding request header.
     *
     * @param contentEncoding the contentEncoding value to set.
     * @return the BlobGetPropertiesHeaders object itself.
     */
    public BlobGetPropertiesHeaders setContentEncoding(String contentEncoding) {
        this.contentEncoding = contentEncoding;
        return this;
    }

    /***
     * Get the contentDisposition property: This header returns the value that
     * was specified for the 'x-ms-blob-content-disposition' header. The
     * Content-Disposition response header field conveys additional information
     * about how to process the response payload, and also can be used to
     * attach additional metadata. For example, if set to attachment, it
     * indicates that the user-agent should not display the response, but
     * instead show a Save As dialog with a filename other than the blob name
     * specified.
     *
     * @return the contentDisposition value.
     */
    public String getContentDisposition() {
        return this.contentDisposition;
    }

    /***
     * Set the contentDisposition property: This header returns the value that
     * was specified for the 'x-ms-blob-content-disposition' header. The
     * Content-Disposition response header field conveys additional information
     * about how to process the response payload, and also can be used to
     * attach additional metadata. For example, if set to attachment, it
     * indicates that the user-agent should not display the response, but
     * instead show a Save As dialog with a filename other than the blob name
     * specified.
     *
     * @param contentDisposition the contentDisposition value to set.
     * @return the BlobGetPropertiesHeaders object itself.
     */
    public BlobGetPropertiesHeaders setContentDisposition(String contentDisposition) {
        this.contentDisposition = contentDisposition;
        return this;
    }

    /***
     * Get the contentLanguage property: This header returns the value that was
     * specified for the Content-Language request header.
     *
     * @return the contentLanguage value.
     */
    public String getContentLanguage() {
        return this.contentLanguage;
    }

    /***
     * Set the contentLanguage property: This header returns the value that was
     * specified for the Content-Language request header.
     *
     * @param contentLanguage the contentLanguage value to set.
     * @return the BlobGetPropertiesHeaders object itself.
     */
    public BlobGetPropertiesHeaders setContentLanguage(String contentLanguage) {
        this.contentLanguage = contentLanguage;
        return this;
    }

    /***
     * Get the cacheControl property: This header is returned if it was
     * previously specified for the blob.
     *
     * @return the cacheControl value.
     */
    public String getCacheControl() {
        return this.cacheControl;
    }

    /***
     * Set the cacheControl property: This header is returned if it was
     * previously specified for the blob.
     *
     * @param cacheControl the cacheControl value to set.
     * @return the BlobGetPropertiesHeaders object itself.
     */
    public BlobGetPropertiesHeaders setCacheControl(String cacheControl) {
        this.cacheControl = cacheControl;
        return this;
    }

    /***
     * Get the blobSequenceNumber property: The current sequence number for a
     * page blob. This header is not returned for block blobs or append blobs.
     *
     * @return the blobSequenceNumber value.
     */
    public Long getBlobSequenceNumber() {
        return this.blobSequenceNumber;
    }

    /***
     * Set the blobSequenceNumber property: The current sequence number for a
     * page blob. This header is not returned for block blobs or append blobs.
     *
     * @param blobSequenceNumber the blobSequenceNumber value to set.
     * @return the BlobGetPropertiesHeaders object itself.
     */
    public BlobGetPropertiesHeaders setBlobSequenceNumber(Long blobSequenceNumber) {
        this.blobSequenceNumber = blobSequenceNumber;
        return this;
    }

    /***
     * Get the clientRequestId property: If a client request id header is sent
     * in the request, this header will be present in the response with the
     * same value.
     *
     * @return the clientRequestId value.
     */
    public String getClientRequestId() {
        return this.clientRequestId;
    }

    /***
     * Set the clientRequestId property: If a client request id header is sent
     * in the request, this header will be present in the response with the
     * same value.
     *
     * @param clientRequestId the clientRequestId value to set.
     * @return the BlobGetPropertiesHeaders object itself.
     */
    public BlobGetPropertiesHeaders setClientRequestId(String clientRequestId) {
        this.clientRequestId = clientRequestId;
        return this;
    }

    /***
     * Get the requestId property: This header uniquely identifies the request
     * that was made and can be used for troubleshooting the request.
     *
     * @return the requestId value.
     */
    public String getRequestId() {
        return this.requestId;
    }

    /***
     * Set the requestId property: This header uniquely identifies the request
     * that was made and can be used for troubleshooting the request.
     *
     * @param requestId the requestId value to set.
     * @return the BlobGetPropertiesHeaders object itself.
     */
    public BlobGetPropertiesHeaders setRequestId(String requestId) {
        this.requestId = requestId;
        return this;
    }

    /***
     * Get the version property: Indicates the version of the Blob service used
     * to execute the request. This header is returned for requests made
     * against version 2009-09-19 and above.
     *
     * @return the version value.
     */
    public String getVersion() {
        return this.version;
    }

    /***
     * Set the version property: Indicates the version of the Blob service used
     * to execute the request. This header is returned for requests made
     * against version 2009-09-19 and above.
     *
     * @param version the version value to set.
     * @return the BlobGetPropertiesHeaders object itself.
     */
    public BlobGetPropertiesHeaders setVersion(String version) {
        this.version = version;
        return this;
    }

    /***
     * Get the dateProperty property: UTC date/time value generated by the
     * service that indicates the time at which the response was initiated.
     *
     * @return the dateProperty value.
     */
    public OffsetDateTime getDateProperty() {
        if (this.dateProperty == null) {
            return null;
        }
        return this.dateProperty.getDateTime();
    }

    /***
     * Set the dateProperty property: UTC date/time value generated by the
     * service that indicates the time at which the response was initiated.
     *
     * @param dateProperty the dateProperty value to set.
     * @return the BlobGetPropertiesHeaders object itself.
     */
    public BlobGetPropertiesHeaders setDateProperty(OffsetDateTime dateProperty) {
        if (dateProperty == null) {
            this.dateProperty = null;
        } else {
            this.dateProperty = new DateTimeRfc1123(dateProperty);
        }
        return this;
    }

    /***
     * Get the acceptRanges property: Indicates that the service supports
     * requests for partial blob content.
     *
     * @return the acceptRanges value.
     */
    public String getAcceptRanges() {
        return this.acceptRanges;
    }

    /***
     * Set the acceptRanges property: Indicates that the service supports
     * requests for partial blob content.
     *
     * @param acceptRanges the acceptRanges value to set.
     * @return the BlobGetPropertiesHeaders object itself.
     */
    public BlobGetPropertiesHeaders setAcceptRanges(String acceptRanges) {
        this.acceptRanges = acceptRanges;
        return this;
    }

    /***
     * Get the blobCommittedBlockCount property: The number of committed blocks
     * present in the blob. This header is returned only for append blobs.
     *
     * @return the blobCommittedBlockCount value.
     */
    public Integer getBlobCommittedBlockCount() {
        return this.blobCommittedBlockCount;
    }

    /***
     * Set the blobCommittedBlockCount property: The number of committed blocks
     * present in the blob. This header is returned only for append blobs.
     *
     * @param blobCommittedBlockCount the blobCommittedBlockCount value to set.
     * @return the BlobGetPropertiesHeaders object itself.
     */
    public BlobGetPropertiesHeaders setBlobCommittedBlockCount(Integer blobCommittedBlockCount) {
        this.blobCommittedBlockCount = blobCommittedBlockCount;
        return this;
    }

    /***
     * Get the isServerEncrypted property: The value of this header is set to
     * true if the blob data and application metadata are completely encrypted
     * using the specified algorithm. Otherwise, the value is set to false
     * (when the blob is unencrypted, or if only parts of the blob/application
     * metadata are encrypted).
     *
     * @return the isServerEncrypted value.
     */
    public Boolean isServerEncrypted() {
        return this.isServerEncrypted;
    }

    /***
     * Set the isServerEncrypted property: The value of this header is set to
     * true if the blob data and application metadata are completely encrypted
     * using the specified algorithm. Otherwise, the value is set to false
     * (when the blob is unencrypted, or if only parts of the blob/application
     * metadata are encrypted).
     *
     * @param isServerEncrypted the isServerEncrypted value to set.
     * @return the BlobGetPropertiesHeaders object itself.
     */
    public BlobGetPropertiesHeaders setIsServerEncrypted(Boolean isServerEncrypted) {
        this.isServerEncrypted = isServerEncrypted;
        return this;
    }

    /***
     * Get the encryptionKeySha256 property: The SHA-256 hash of the encryption
     * key used to encrypt the metadata. This header is only returned when the
     * metadata was encrypted with a customer-provided key.
     *
     * @return the encryptionKeySha256 value.
     */
    public String getEncryptionKeySha256() {
        return this.encryptionKeySha256;
    }

    /***
     * Set the encryptionKeySha256 property: The SHA-256 hash of the encryption
     * key used to encrypt the metadata. This header is only returned when the
     * metadata was encrypted with a customer-provided key.
     *
     * @param encryptionKeySha256 the encryptionKeySha256 value to set.
     * @return the BlobGetPropertiesHeaders object itself.
     */
    public BlobGetPropertiesHeaders setEncryptionKeySha256(String encryptionKeySha256) {
        this.encryptionKeySha256 = encryptionKeySha256;
        return this;
    }

    /***
     * Get the encryptionScope property: Returns the name of the encryption
     * scope used to encrypt the blob contents and application metadata.  Note
     * that the absence of this header implies use of the default account
     * encryption scope.
     *
     * @return the encryptionScope value.
     */
    public String getEncryptionScope() {
        return this.encryptionScope;
    }

    /***
     * Set the encryptionScope property: Returns the name of the encryption
     * scope used to encrypt the blob contents and application metadata.  Note
     * that the absence of this header implies use of the default account
     * encryption scope.
     *
     * @param encryptionScope the encryptionScope value to set.
     * @return the BlobGetPropertiesHeaders object itself.
     */
    public BlobGetPropertiesHeaders setEncryptionScope(String encryptionScope) {
        this.encryptionScope = encryptionScope;
        return this;
    }

    /***
     * Get the accessTier property: The tier of page blob on a premium storage
     * account or tier of block blob on blob storage LRS accounts. For a list
     * of allowed premium page blob tiers, see
     * https://docs.microsoft.com/en-us/azure/virtual-machines/windows/premium-storage#features.
     * For blob storage LRS accounts, valid values are Hot/Cool/Archive.
     *
     * @return the accessTier value.
     */
    public String getAccessTier() {
        return this.accessTier;
    }

    /***
     * Set the accessTier property: The tier of page blob on a premium storage
     * account or tier of block blob on blob storage LRS accounts. For a list
     * of allowed premium page blob tiers, see
     * https://docs.microsoft.com/en-us/azure/virtual-machines/windows/premium-storage#features.
     * For blob storage LRS accounts, valid values are Hot/Cool/Archive.
     *
     * @param accessTier the accessTier value to set.
     * @return the BlobGetPropertiesHeaders object itself.
     */
    public BlobGetPropertiesHeaders setAccessTier(String accessTier) {
        this.accessTier = accessTier;
        return this;
    }

    /***
     * Get the accessTierInferred property: For page blobs on a premium storage
     * account only. If the access tier is not explicitly set on the blob, the
     * tier is inferred based on its content length and this header will be
     * returned with true value.
     *
     * @return the accessTierInferred value.
     */
    public Boolean isAccessTierInferred() {
        return this.accessTierInferred;
    }

    /***
     * Set the accessTierInferred property: For page blobs on a premium storage
     * account only. If the access tier is not explicitly set on the blob, the
     * tier is inferred based on its content length and this header will be
     * returned with true value.
     *
     * @param accessTierInferred the accessTierInferred value to set.
     * @return the BlobGetPropertiesHeaders object itself.
     */
    public BlobGetPropertiesHeaders setAccessTierInferred(Boolean accessTierInferred) {
        this.accessTierInferred = accessTierInferred;
        return this;
    }

    /***
     * Get the archiveStatus property: For blob storage LRS accounts, valid
     * values are rehydrate-pending-to-hot/rehydrate-pending-to-cool. If the
     * blob is being rehydrated and is not complete then this header is
     * returned indicating that rehydrate is pending and also tells the
     * destination tier.
     *
     * @return the archiveStatus value.
     */
    public String getArchiveStatus() {
        return this.archiveStatus;
    }

    /***
     * Set the archiveStatus property: For blob storage LRS accounts, valid
     * values are rehydrate-pending-to-hot/rehydrate-pending-to-cool. If the
     * blob is being rehydrated and is not complete then this header is
     * returned indicating that rehydrate is pending and also tells the
     * destination tier.
     *
     * @param archiveStatus the archiveStatus value to set.
     * @return the BlobGetPropertiesHeaders object itself.
     */
    public BlobGetPropertiesHeaders setArchiveStatus(String archiveStatus) {
        this.archiveStatus = archiveStatus;
        return this;
    }

    /***
     * Get the accessTierChangeTime property: The time the tier was changed on
     * the object. This is only returned if the tier on the block blob was ever
     * set.
     *
     * @return the accessTierChangeTime value.
     */
    public OffsetDateTime getAccessTierChangeTime() {
        if (this.accessTierChangeTime == null) {
            return null;
        }
        return this.accessTierChangeTime.getDateTime();
    }

    /***
     * Set the accessTierChangeTime property: The time the tier was changed on
     * the object. This is only returned if the tier on the block blob was ever
     * set.
     *
     * @param accessTierChangeTime the accessTierChangeTime value to set.
     * @return the BlobGetPropertiesHeaders object itself.
     */
    public BlobGetPropertiesHeaders setAccessTierChangeTime(OffsetDateTime accessTierChangeTime) {
        if (accessTierChangeTime == null) {
            this.accessTierChangeTime = null;
        } else {
            this.accessTierChangeTime = new DateTimeRfc1123(accessTierChangeTime);
        }
        return this;
    }

    /***
     * Get the errorCode property: The errorCode property.
     *
     * @return the errorCode value.
     */
    public String getErrorCode() {
        return this.errorCode;
    }

    /***
     * Set the errorCode property: The errorCode property.
     *
     * @param errorCode the errorCode value to set.
     * @return the BlobGetPropertiesHeaders object itself.
     */
    public BlobGetPropertiesHeaders setErrorCode(String errorCode) {
        this.errorCode = errorCode;
        return this;
    }
}