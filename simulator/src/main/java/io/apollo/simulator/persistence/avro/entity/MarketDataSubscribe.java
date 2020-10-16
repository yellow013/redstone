/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package io.apollo.simulator.persistence.avro.entity;

import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.SchemaStore;
import org.apache.avro.specific.SpecificData;

@org.apache.avro.specific.AvroGenerated
public class MarketDataSubscribe extends org.apache.avro.specific.SpecificRecordBase
		implements org.apache.avro.specific.SpecificRecord {
	private static final long serialVersionUID = 5634526171103313470L;
	public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse(
			"{\"type\":\"record\",\"name\":\"MarketDataSubscribe\",\"namespace\":\"io.mercury.simulator.persistence.avro.entity\",\"fields\":[{\"name\":\"uniqueId\",\"type\":\"int\"},{\"name\":\"startTradingDay\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"endTradingDay\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"instrumentIdList\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"string\",\"avro.java.string\":\"String\"}}}]}");

	public static org.apache.avro.Schema getClassSchema() {
		return SCHEMA$;
	}

	private static SpecificData MODEL$ = new SpecificData();

	private static final BinaryMessageEncoder<MarketDataSubscribe> ENCODER = new BinaryMessageEncoder<MarketDataSubscribe>(
			MODEL$, SCHEMA$);

	private static final BinaryMessageDecoder<MarketDataSubscribe> DECODER = new BinaryMessageDecoder<MarketDataSubscribe>(
			MODEL$, SCHEMA$);

	/**
	 * Return the BinaryMessageEncoder instance used by this class.
	 * 
	 * @return the message encoder used by this class
	 */
	public static BinaryMessageEncoder<MarketDataSubscribe> getEncoder() {
		return ENCODER;
	}

	/**
	 * Return the BinaryMessageDecoder instance used by this class.
	 * 
	 * @return the message decoder used by this class
	 */
	public static BinaryMessageDecoder<MarketDataSubscribe> getDecoder() {
		return DECODER;
	}

	/**
	 * Create a new BinaryMessageDecoder instance for this class that uses the
	 * specified {@link SchemaStore}.
	 * 
	 * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
	 * @return a BinaryMessageDecoder instance for this class backed by the given
	 *         SchemaStore
	 */
	public static BinaryMessageDecoder<MarketDataSubscribe> createDecoder(SchemaStore resolver) {
		return new BinaryMessageDecoder<MarketDataSubscribe>(MODEL$, SCHEMA$, resolver);
	}

	/**
	 * Serializes this MarketDataSubscribe to a ByteBuffer.
	 * 
	 * @return a buffer holding the serialized data for this instance
	 * @throws java.io.IOException if this instance could not be serialized
	 */
	public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
		return ENCODER.encode(this);
	}

	/**
	 * Deserializes a MarketDataSubscribe from a ByteBuffer.
	 * 
	 * @param b a byte buffer holding serialized data for an instance of this class
	 * @return a MarketDataSubscribe instance decoded from the given buffer
	 * @throws java.io.IOException if the given bytes could not be deserialized into
	 *                             an instance of this class
	 */
	public static MarketDataSubscribe fromByteBuffer(java.nio.ByteBuffer b) throws java.io.IOException {
		return DECODER.decode(b);
	}

	private int uniqueId;
	private java.lang.String startTradingDay;
	private java.lang.String endTradingDay;
	private java.util.List<java.lang.String> instrumentIdList;

	/**
	 * Default constructor. Note that this does not initialize fields to their
	 * default values from the schema. If that is desired then one should use
	 * <code>newBuilder()</code>.
	 */
	public MarketDataSubscribe() {
	}

	/**
	 * All-args constructor.
	 * 
	 * @param uniqueId         The new value for uniqueId
	 * @param startTradingDay  The new value for startTradingDay
	 * @param endTradingDay    The new value for endTradingDay
	 * @param instrumentIdList The new value for instrumentIdList
	 */
	public MarketDataSubscribe(java.lang.Integer uniqueId, java.lang.String startTradingDay,
			java.lang.String endTradingDay, java.util.List<java.lang.String> instrumentIdList) {
		this.uniqueId = uniqueId;
		this.startTradingDay = startTradingDay;
		this.endTradingDay = endTradingDay;
		this.instrumentIdList = instrumentIdList;
	}

	public org.apache.avro.specific.SpecificData getSpecificData() {
		return MODEL$;
	}

	public org.apache.avro.Schema getSchema() {
		return SCHEMA$;
	}

	// Used by DatumWriter. Applications should not call.
	public java.lang.Object get(int field$) {
		switch (field$) {
		case 0:
			return uniqueId;
		case 1:
			return startTradingDay;
		case 2:
			return endTradingDay;
		case 3:
			return instrumentIdList;
		default:
			throw new org.apache.avro.AvroRuntimeException("Bad index");
		}
	}

	// Used by DatumReader. Applications should not call.
	@SuppressWarnings(value = "unchecked")
	public void put(int field$, java.lang.Object value$) {
		switch (field$) {
		case 0:
			uniqueId = (java.lang.Integer) value$;
			break;
		case 1:
			startTradingDay = value$ != null ? value$.toString() : null;
			break;
		case 2:
			endTradingDay = value$ != null ? value$.toString() : null;
			break;
		case 3:
			instrumentIdList = (java.util.List<java.lang.String>) value$;
			break;
		default:
			throw new org.apache.avro.AvroRuntimeException("Bad index");
		}
	}

	/**
	 * Gets the value of the 'uniqueId' field.
	 * 
	 * @return The value of the 'uniqueId' field.
	 */
	public int getUniqueId() {
		return uniqueId;
	}

	/**
	 * Sets the value of the 'uniqueId' field.
	 * 
	 * @param value the value to set.
	 */
	public void setUniqueId(int value) {
		this.uniqueId = value;
	}

	/**
	 * Gets the value of the 'startTradingDay' field.
	 * 
	 * @return The value of the 'startTradingDay' field.
	 */
	public java.lang.String getStartTradingDay() {
		return startTradingDay;
	}

	/**
	 * Sets the value of the 'startTradingDay' field.
	 * 
	 * @param value the value to set.
	 */
	public void setStartTradingDay(java.lang.String value) {
		this.startTradingDay = value;
	}

	/**
	 * Gets the value of the 'endTradingDay' field.
	 * 
	 * @return The value of the 'endTradingDay' field.
	 */
	public java.lang.String getEndTradingDay() {
		return endTradingDay;
	}

	/**
	 * Sets the value of the 'endTradingDay' field.
	 * 
	 * @param value the value to set.
	 */
	public void setEndTradingDay(java.lang.String value) {
		this.endTradingDay = value;
	}

	/**
	 * Gets the value of the 'instrumentIdList' field.
	 * 
	 * @return The value of the 'instrumentIdList' field.
	 */
	public java.util.List<java.lang.String> getInstrumentIdList() {
		return instrumentIdList;
	}

	/**
	 * Sets the value of the 'instrumentIdList' field.
	 * 
	 * @param value the value to set.
	 */
	public void setInstrumentIdList(java.util.List<java.lang.String> value) {
		this.instrumentIdList = value;
	}

	/**
	 * Creates a new MarketDataSubscribe RecordBuilder.
	 * 
	 * @return A new MarketDataSubscribe RecordBuilder
	 */
	public static io.apollo.simulator.persistence.avro.entity.MarketDataSubscribe.Builder newBuilder() {
		return new io.apollo.simulator.persistence.avro.entity.MarketDataSubscribe.Builder();
	}

	/**
	 * Creates a new MarketDataSubscribe RecordBuilder by copying an existing
	 * Builder.
	 * 
	 * @param other The existing builder to copy.
	 * @return A new MarketDataSubscribe RecordBuilder
	 */
	public static io.apollo.simulator.persistence.avro.entity.MarketDataSubscribe.Builder newBuilder(
			io.apollo.simulator.persistence.avro.entity.MarketDataSubscribe.Builder other) {
		if (other == null) {
			return new io.apollo.simulator.persistence.avro.entity.MarketDataSubscribe.Builder();
		} else {
			return new io.apollo.simulator.persistence.avro.entity.MarketDataSubscribe.Builder(other);
		}
	}

	/**
	 * Creates a new MarketDataSubscribe RecordBuilder by copying an existing
	 * MarketDataSubscribe instance.
	 * 
	 * @param other The existing instance to copy.
	 * @return A new MarketDataSubscribe RecordBuilder
	 */
	public static io.apollo.simulator.persistence.avro.entity.MarketDataSubscribe.Builder newBuilder(
			io.apollo.simulator.persistence.avro.entity.MarketDataSubscribe other) {
		if (other == null) {
			return new io.apollo.simulator.persistence.avro.entity.MarketDataSubscribe.Builder();
		} else {
			return new io.apollo.simulator.persistence.avro.entity.MarketDataSubscribe.Builder(other);
		}
	}

	/**
	 * RecordBuilder for MarketDataSubscribe instances.
	 */
	@org.apache.avro.specific.AvroGenerated
	public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<MarketDataSubscribe>
			implements org.apache.avro.data.RecordBuilder<MarketDataSubscribe> {

		private int uniqueId;
		private java.lang.String startTradingDay;
		private java.lang.String endTradingDay;
		private java.util.List<java.lang.String> instrumentIdList;

		/** Creates a new Builder */
		private Builder() {
			super(SCHEMA$);
		}

		/**
		 * Creates a Builder by copying an existing Builder.
		 * 
		 * @param other The existing Builder to copy.
		 */
		private Builder(io.apollo.simulator.persistence.avro.entity.MarketDataSubscribe.Builder other) {
			super(other);
			if (isValidValue(fields()[0], other.uniqueId)) {
				this.uniqueId = data().deepCopy(fields()[0].schema(), other.uniqueId);
				fieldSetFlags()[0] = other.fieldSetFlags()[0];
			}
			if (isValidValue(fields()[1], other.startTradingDay)) {
				this.startTradingDay = data().deepCopy(fields()[1].schema(), other.startTradingDay);
				fieldSetFlags()[1] = other.fieldSetFlags()[1];
			}
			if (isValidValue(fields()[2], other.endTradingDay)) {
				this.endTradingDay = data().deepCopy(fields()[2].schema(), other.endTradingDay);
				fieldSetFlags()[2] = other.fieldSetFlags()[2];
			}
			if (isValidValue(fields()[3], other.instrumentIdList)) {
				this.instrumentIdList = data().deepCopy(fields()[3].schema(), other.instrumentIdList);
				fieldSetFlags()[3] = other.fieldSetFlags()[3];
			}
		}

		/**
		 * Creates a Builder by copying an existing MarketDataSubscribe instance
		 * 
		 * @param other The existing instance to copy.
		 */
		private Builder(io.apollo.simulator.persistence.avro.entity.MarketDataSubscribe other) {
			super(SCHEMA$);
			if (isValidValue(fields()[0], other.uniqueId)) {
				this.uniqueId = data().deepCopy(fields()[0].schema(), other.uniqueId);
				fieldSetFlags()[0] = true;
			}
			if (isValidValue(fields()[1], other.startTradingDay)) {
				this.startTradingDay = data().deepCopy(fields()[1].schema(), other.startTradingDay);
				fieldSetFlags()[1] = true;
			}
			if (isValidValue(fields()[2], other.endTradingDay)) {
				this.endTradingDay = data().deepCopy(fields()[2].schema(), other.endTradingDay);
				fieldSetFlags()[2] = true;
			}
			if (isValidValue(fields()[3], other.instrumentIdList)) {
				this.instrumentIdList = data().deepCopy(fields()[3].schema(), other.instrumentIdList);
				fieldSetFlags()[3] = true;
			}
		}

		/**
		 * Gets the value of the 'uniqueId' field.
		 * 
		 * @return The value.
		 */
		public int getUniqueId() {
			return uniqueId;
		}

		/**
		 * Sets the value of the 'uniqueId' field.
		 * 
		 * @param value The value of 'uniqueId'.
		 * @return This builder.
		 */
		public io.apollo.simulator.persistence.avro.entity.MarketDataSubscribe.Builder setUniqueId(int value) {
			validate(fields()[0], value);
			this.uniqueId = value;
			fieldSetFlags()[0] = true;
			return this;
		}

		/**
		 * Checks whether the 'uniqueId' field has been set.
		 * 
		 * @return True if the 'uniqueId' field has been set, false otherwise.
		 */
		public boolean hasUniqueId() {
			return fieldSetFlags()[0];
		}

		/**
		 * Clears the value of the 'uniqueId' field.
		 * 
		 * @return This builder.
		 */
		public io.apollo.simulator.persistence.avro.entity.MarketDataSubscribe.Builder clearUniqueId() {
			fieldSetFlags()[0] = false;
			return this;
		}

		/**
		 * Gets the value of the 'startTradingDay' field.
		 * 
		 * @return The value.
		 */
		public java.lang.String getStartTradingDay() {
			return startTradingDay;
		}

		/**
		 * Sets the value of the 'startTradingDay' field.
		 * 
		 * @param value The value of 'startTradingDay'.
		 * @return This builder.
		 */
		public io.apollo.simulator.persistence.avro.entity.MarketDataSubscribe.Builder setStartTradingDay(
				java.lang.String value) {
			validate(fields()[1], value);
			this.startTradingDay = value;
			fieldSetFlags()[1] = true;
			return this;
		}

		/**
		 * Checks whether the 'startTradingDay' field has been set.
		 * 
		 * @return True if the 'startTradingDay' field has been set, false otherwise.
		 */
		public boolean hasStartTradingDay() {
			return fieldSetFlags()[1];
		}

		/**
		 * Clears the value of the 'startTradingDay' field.
		 * 
		 * @return This builder.
		 */
		public io.apollo.simulator.persistence.avro.entity.MarketDataSubscribe.Builder clearStartTradingDay() {
			startTradingDay = null;
			fieldSetFlags()[1] = false;
			return this;
		}

		/**
		 * Gets the value of the 'endTradingDay' field.
		 * 
		 * @return The value.
		 */
		public java.lang.String getEndTradingDay() {
			return endTradingDay;
		}

		/**
		 * Sets the value of the 'endTradingDay' field.
		 * 
		 * @param value The value of 'endTradingDay'.
		 * @return This builder.
		 */
		public io.apollo.simulator.persistence.avro.entity.MarketDataSubscribe.Builder setEndTradingDay(
				java.lang.String value) {
			validate(fields()[2], value);
			this.endTradingDay = value;
			fieldSetFlags()[2] = true;
			return this;
		}

		/**
		 * Checks whether the 'endTradingDay' field has been set.
		 * 
		 * @return True if the 'endTradingDay' field has been set, false otherwise.
		 */
		public boolean hasEndTradingDay() {
			return fieldSetFlags()[2];
		}

		/**
		 * Clears the value of the 'endTradingDay' field.
		 * 
		 * @return This builder.
		 */
		public io.apollo.simulator.persistence.avro.entity.MarketDataSubscribe.Builder clearEndTradingDay() {
			endTradingDay = null;
			fieldSetFlags()[2] = false;
			return this;
		}

		/**
		 * Gets the value of the 'instrumentIdList' field.
		 * 
		 * @return The value.
		 */
		public java.util.List<java.lang.String> getInstrumentIdList() {
			return instrumentIdList;
		}

		/**
		 * Sets the value of the 'instrumentIdList' field.
		 * 
		 * @param value The value of 'instrumentIdList'.
		 * @return This builder.
		 */
		public io.apollo.simulator.persistence.avro.entity.MarketDataSubscribe.Builder setInstrumentIdList(
				java.util.List<java.lang.String> value) {
			validate(fields()[3], value);
			this.instrumentIdList = value;
			fieldSetFlags()[3] = true;
			return this;
		}

		/**
		 * Checks whether the 'instrumentIdList' field has been set.
		 * 
		 * @return True if the 'instrumentIdList' field has been set, false otherwise.
		 */
		public boolean hasInstrumentIdList() {
			return fieldSetFlags()[3];
		}

		/**
		 * Clears the value of the 'instrumentIdList' field.
		 * 
		 * @return This builder.
		 */
		public io.apollo.simulator.persistence.avro.entity.MarketDataSubscribe.Builder clearInstrumentIdList() {
			instrumentIdList = null;
			fieldSetFlags()[3] = false;
			return this;
		}

		@Override
		@SuppressWarnings("unchecked")
		public MarketDataSubscribe build() {
			try {
				MarketDataSubscribe record = new MarketDataSubscribe();
				record.uniqueId = fieldSetFlags()[0] ? this.uniqueId : (java.lang.Integer) defaultValue(fields()[0]);
				record.startTradingDay = fieldSetFlags()[1] ? this.startTradingDay
						: (java.lang.String) defaultValue(fields()[1]);
				record.endTradingDay = fieldSetFlags()[2] ? this.endTradingDay
						: (java.lang.String) defaultValue(fields()[2]);
				record.instrumentIdList = fieldSetFlags()[3] ? this.instrumentIdList
						: (java.util.List<java.lang.String>) defaultValue(fields()[3]);
				return record;
			} catch (org.apache.avro.AvroMissingFieldException e) {
				throw e;
			} catch (java.lang.Exception e) {
				throw new org.apache.avro.AvroRuntimeException(e);
			}
		}
	}

	@SuppressWarnings("unchecked")
	private static final org.apache.avro.io.DatumWriter<MarketDataSubscribe> WRITER$ = (org.apache.avro.io.DatumWriter<MarketDataSubscribe>) MODEL$
			.createDatumWriter(SCHEMA$);

	@Override
	public void writeExternal(java.io.ObjectOutput out) throws java.io.IOException {
		WRITER$.write(this, SpecificData.getEncoder(out));
	}

	@SuppressWarnings("unchecked")
	private static final org.apache.avro.io.DatumReader<MarketDataSubscribe> READER$ = (org.apache.avro.io.DatumReader<MarketDataSubscribe>) MODEL$
			.createDatumReader(SCHEMA$);

	@Override
	public void readExternal(java.io.ObjectInput in) throws java.io.IOException {
		READER$.read(this, SpecificData.getDecoder(in));
	}

	@Override
	protected boolean hasCustomCoders() {
		return true;
	}

	@Override
	public void customEncode(org.apache.avro.io.Encoder out) throws java.io.IOException {
		out.writeInt(this.uniqueId);

		out.writeString(this.startTradingDay);

		out.writeString(this.endTradingDay);

		long size0 = this.instrumentIdList.size();
		out.writeArrayStart();
		out.setItemCount(size0);
		long actualSize0 = 0;
		for (java.lang.String e0 : this.instrumentIdList) {
			actualSize0++;
			out.startItem();
			out.writeString(e0);
		}
		out.writeArrayEnd();
		if (actualSize0 != size0)
			throw new java.util.ConcurrentModificationException(
					"Array-size written was " + size0 + ", but element count was " + actualSize0 + ".");

	}

	@Override
	public void customDecode(org.apache.avro.io.ResolvingDecoder in) throws java.io.IOException {
		org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
		if (fieldOrder == null) {
			this.uniqueId = in.readInt();

			this.startTradingDay = in.readString();

			this.endTradingDay = in.readString();

			long size0 = in.readArrayStart();
			java.util.List<java.lang.String> a0 = this.instrumentIdList;
			if (a0 == null) {
				a0 = new SpecificData.Array<java.lang.String>((int) size0,
						SCHEMA$.getField("instrumentIdList").schema());
				this.instrumentIdList = a0;
			} else
				a0.clear();
			SpecificData.Array<java.lang.String> ga0 = (a0 instanceof SpecificData.Array
					? (SpecificData.Array<java.lang.String>) a0
					: null);
			for (; 0 < size0; size0 = in.arrayNext()) {
				for (; size0 != 0; size0--) {
					java.lang.String e0 = (ga0 != null ? ga0.peek() : null);
					e0 = in.readString();
					a0.add(e0);
				}
			}

		} else {
			for (int i = 0; i < 4; i++) {
				switch (fieldOrder[i].pos()) {
				case 0:
					this.uniqueId = in.readInt();
					break;

				case 1:
					this.startTradingDay = in.readString();
					break;

				case 2:
					this.endTradingDay = in.readString();
					break;

				case 3:
					long size0 = in.readArrayStart();
					java.util.List<java.lang.String> a0 = this.instrumentIdList;
					if (a0 == null) {
						a0 = new SpecificData.Array<java.lang.String>((int) size0,
								SCHEMA$.getField("instrumentIdList").schema());
						this.instrumentIdList = a0;
					} else
						a0.clear();
					SpecificData.Array<java.lang.String> ga0 = (a0 instanceof SpecificData.Array
							? (SpecificData.Array<java.lang.String>) a0
							: null);
					for (; 0 < size0; size0 = in.arrayNext()) {
						for (; size0 != 0; size0--) {
							java.lang.String e0 = (ga0 != null ? ga0.peek() : null);
							e0 = in.readString();
							a0.add(e0);
						}
					}
					break;

				default:
					throw new java.io.IOException("Corrupt ResolvingDecoder.");
				}
			}
		}
	}
}
