/*
 * TeleStax, Open Source Cloud Communications
 * Copyright 2011-2016, Telestax Inc and individual contributors
 * by the @authors tag.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

package org.jdiameter.common.impl.app.slg;

import org.jdiameter.api.Avp;
import org.jdiameter.api.Answer;
import org.jdiameter.api.Request;
import org.jdiameter.api.AvpDataException;
import org.jdiameter.api.slg.events.ProvideLocationAnswer;
import org.jdiameter.common.impl.app.AppRequestEventImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author fernando.mendioroz@telestax.com (Fernando Mendioroz)
 *
 */

public class ProvideLocationAnswerImpl extends AppRequestEventImpl implements ProvideLocationAnswer {

  private static final long serialVersionUID = 1L;

  protected static final Logger logger = LoggerFactory.getLogger(ProvideLocationRequestImpl.class);

  /**
   *
   * @param answer
   */
  public ProvideLocationAnswerImpl(Answer answer) {
    super(answer);
  }

  /**
   *
   * @param request
   * @param resultCode
   */
  public ProvideLocationAnswerImpl(Request request, long resultCode) {
        super(request.createAnswer(resultCode));
  }

  public Avp getResultCodeAvp() throws AvpDataException {
    return null;
  }

  @Override
  public boolean isLocationEstimateAvpPresent(){
    return super.message.getAvps().getAvp(Avp.LOCATION_ESTIMATE) != null;
  }

  @Override
  public String getLocationEstimate() {
    Avp lcsLocationEstimateAvp = super.message.getAvps().getAvp(Avp.LOCATION_ESTIMATE);
    if (lcsLocationEstimateAvp != null) {
      try {
        return lcsLocationEstimateAvp.getUTF8String();
      } catch (AvpDataException e) {
        logger.debug("Failure trying to obtain LCS Location-Estimate AVP value", e);
      }
    }
    return null;
  }

  @Override
  public boolean isAccuracyFulfilmentIndicatorAvpPresent(){
    return super.message.getAvps().getAvp(Avp.ACCURACY_FULFILMENT_INDICATOR) != null;
  }

  @Override
  public int getAccuracyFulfilmentIndicator() {
    Avp lcsAccuracyFulfilmentIndAvp = super.message.getAvps().getAvp(Avp.ACCURACY_FULFILMENT_INDICATOR);
    if (lcsAccuracyFulfilmentIndAvp != null) {
      try {
        return lcsAccuracyFulfilmentIndAvp.getInteger32();
      } catch (AvpDataException e) {
        logger.debug("Failure trying to obtain LCS Accuracy fulfilment indicator AVP value", e);
      }
    }
    return -1;
  }

  @Override
  public boolean isAgeOfLocationEstimateAvpPresent(){
    return super.message.getAvps().getAvp(Avp.AGE_OF_LOCATION_ESTIMATE) != null;
  }

  @Override
  public long getAgeOfLocationEstimate() {
    Avp lcsAgeOfLocEstimateAvp = super.message.getAvps().getAvp(Avp.AGE_OF_LOCATION_ESTIMATE);
    if (lcsAgeOfLocEstimateAvp != null) {
      try {
        return lcsAgeOfLocEstimateAvp.getUnsigned32();
      } catch (AvpDataException e) {
        logger.debug("Failure trying to obtain LCS Age of Location Estimate AVP value", e);
      }
    }
    return -1;
  }

  @Override
  public boolean isVelocityEstimateAvpPresent(){
    return super.message.getAvps().getAvp(Avp.VELOCITY_ESTIMATE) != null;
  }

  @Override
  public byte[] getVelocityEstimate() {
    Avp lcsVelEstimateAvp = super.message.getAvps().getAvp(Avp.VELOCITY_ESTIMATE);
    if (lcsVelEstimateAvp != null) {
      try {
        return lcsVelEstimateAvp.getOctetString();
      } catch (AvpDataException e) {
        logger.debug("Failure trying to obtain LCS Velocity Estimate AVP value", e);
      }
    }
    return null;
  }

  @Override
  public boolean isEUTRANPositioningDataAvpPresent(){
    return super.message.getAvps().getAvp(Avp.EUTRAN_POSITIONING_DATA) != null;
  }

  @Override
  public byte[] getEUTRANPositioningData() {
    Avp lcsEUTRANPosDataAvp = super.message.getAvps().getAvp(Avp.EUTRAN_POSITIONING_DATA);
    if (lcsEUTRANPosDataAvp != null) {
      try {
        return lcsEUTRANPosDataAvp.getOctetString();
      } catch (AvpDataException e) {
        logger.debug("Failure trying to obtain LCS E-UTRAN-Positioning-Data AVP value", e);
      }
    }
    return null;
  }

  @Override
  public boolean isECGIAvpPresent(){
    return super.message.getAvps().getAvp(Avp.ECGI) != null;
  }

  @Override
  public byte[] getECGI(){
    Avp lcsECGIAvp = super.message.getAvps().getAvp(Avp.ECGI);
    if (lcsECGIAvp != null) {
      try {
        return lcsECGIAvp.getOctetString();
      } catch (AvpDataException e) {
        logger.debug("Failure trying to obtain LCS ECGI AVP value", e);
      }
    }
    return null;
  }

  @Override
  public boolean isGERANPositioningInfoAvpPresent(){
    return super.message.getAvps().getAvp(Avp.GERAN_POSITIONING_INFO) != null;
  }

  @Override
  public byte[] getGERANPositioningData(){
    Avp lcsGERANPositioningDataAvp = super.message.getAvps().getAvp(Avp.GERAN_POSITIONING_DATA);
    if (lcsGERANPositioningDataAvp != null) {
      try {
        return lcsGERANPositioningDataAvp.getOctetString();
      } catch (AvpDataException e) {
        logger.debug("Failure trying to obtain LCS GERAN-Positioning-Data AVP value", e);
      }
    }
    return null;
  }

  @Override
  public byte[] getGERANGANSSPositioningData(){
    Avp lcsGERANGANSSPositioningDataAvp = super.message.getAvps().getAvp(Avp.GERAN_GANSS_POSITIONING_DATA);
    if (lcsGERANGANSSPositioningDataAvp != null) {
      try {
        return lcsGERANGANSSPositioningDataAvp.getOctetString();
      } catch (AvpDataException e) {
        logger.debug("Failure trying to obtain LCS GERAN-GANSS-Positioning-Data AVP value", e);
      }
    }
    return null;
  }

  @Override
  public boolean isCellGlobalIdentityAvpPresent(){
    return super.message.getAvps().getAvp(Avp.CELL_GLOBAL_IDENTITY) != null;
  }

  @Override
  public byte[] getCellGlobalIdentity(){
    Avp lcsCellGlobalIdAvp = super.message.getAvps().getAvp(Avp.CELL_GLOBAL_IDENTITY);
    if (lcsCellGlobalIdAvp != null) {
      try {
        return lcsCellGlobalIdAvp.getOctetString();
      } catch (AvpDataException e) {
        logger.debug("Failure trying to obtain LCS Cell-Global-Identity AVP value", e);
      }
    }
    return null;
  }

  @Override
  public boolean isUTRANPositioningInfoAvpPresent(){
    return super.message.getAvps().getAvp(Avp.UTRAN_POSITIONING_INFO) != null;
  }

  @Override
  public byte[] getUTRANPositioningData(){
    Avp lcsUTRANPosDataAvp = super.message.getAvps().getAvp(Avp.UTRAN_ADDITIONAL_POSITIONING_DATA);
    if (lcsUTRANPosDataAvp != null) {
      try {
        return lcsUTRANPosDataAvp.getOctetString();
      } catch (AvpDataException e) {
        logger.debug("Failure trying to obtain LCS UTRAN-Positionin-Data AVP value", e);
      }
    }
    return null;
  }

  @Override
  public byte[] getUTRANGANSSPositioningData(){
    Avp lcsUTRANGANSSPosDataAvp = super.message.getAvps().getAvp(Avp.UTRAN_GANSS_POSITIONING_DATA);
    if (lcsUTRANGANSSPosDataAvp != null) {
      try {
        return lcsUTRANGANSSPosDataAvp.getOctetString();
      } catch (AvpDataException e) {
        logger.debug("Failure trying to obtain LCS UTRAN-GANSS-Positionin-Data AVP value", e);
      }
    }
    return null;
  }

  @Override
  public boolean isServiceAreaIdentityAvpPresent(){
    return super.message.getAvps().getAvp(Avp.SERVICE_AREA_IDENTITY) != null;
  }

  @Override
  public byte[] getServiceAreaIdentity(){
    Avp lcsServiceAreaIdentityAvp = super.message.getAvps().getAvp(Avp.SERVICE_AREA_IDENTITY);
    if (lcsServiceAreaIdentityAvp != null) {
      try {
        return lcsServiceAreaIdentityAvp.getOctetString();
      } catch (AvpDataException e) {
        logger.debug("Failure trying to obtain LCS SERVICE-AREA-IDENTITY AVP value", e);
      }
    }
    return null;
  }

  @Override
  public boolean isServingNodeAvpPresent() {
    return super.message.getAvps().getAvp(Avp.SERVING_NODE) != null;
  }

  @Override
  public boolean isPLAFlagsAvpPresent() {
    return super.message.getAvps().getAvp(Avp.PLA_FLAGS) != null;
  }

  @Override
  public long getPLAFlags(){
    Avp lcsPLAFlagsAvp = super.message.getAvps().getAvp(Avp.PLA_FLAGS);
    if (lcsPLAFlagsAvp != null) {
      try {
        return lcsPLAFlagsAvp.getUnsigned32();
      } catch (AvpDataException e) {
        logger.debug("Failure trying to obtain LCS PLA-Flags AVP value", e);
      }
    }
    return -1;
  }

  @Override
  public boolean isESMLCCellInfoAvpPresent(){
    return super.message.getAvps().getAvp(Avp.ESMLC_CELL_INFO) != null;
  }

  @Override
  public long getCellPortionId(){
    Avp lcsCellPortionIdAvp = super.message.getAvps().getAvp(Avp.CELL_PORTION_ID);
    if (lcsCellPortionIdAvp != null) {
      try {
        return lcsCellPortionIdAvp.getUnsigned32();
      } catch (AvpDataException e) {
        logger.debug("Failure trying to obtain LCS Cell-Portion-Id AVP value", e);
      }
    }
    return -1;
  }

  @Override
  public boolean isCivicAddressAvpPresent(){
    return super.message.getAvps().getAvp(Avp.CIVIC_ADDRESS) != null;
  }

  @Override
  public String getCivicAddress(){
    Avp lcsCivicAddressAvp = super.message.getAvps().getAvp(Avp.CIVIC_ADDRESS);
    if (lcsCivicAddressAvp != null) {
      try {
        return lcsCivicAddressAvp.getUTF8String();
      } catch (AvpDataException e) {
        logger.debug("Failure trying to obtain LCS Civic Address AVP value", e);
      }
    }
    return null;
  }

  @Override
  public boolean isBarometricPressureAvpPresent(){
    return super.message.getAvps().getAvp(Avp.BAROMETRIC_PRESSURE) != null;
  }

  @Override
  public long getBarometricPressure(){
    Avp lcsBarometricPressureAvp = super.message.getAvps().getAvp(Avp.BAROMETRIC_PRESSURE);
    if (lcsBarometricPressureAvp != null) {
      try {
        return lcsBarometricPressureAvp.getUnsigned32();
      } catch (AvpDataException e) {
        logger.debug("Failure trying to obtain LCS Barometric Pressure AVP value", e);
      }
    }
    return -1;
  }

}