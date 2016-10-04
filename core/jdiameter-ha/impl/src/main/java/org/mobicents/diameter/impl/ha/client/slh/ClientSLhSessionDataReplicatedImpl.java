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

package org.mobicents.diameter.impl.ha.client.slh;

import org.jboss.cache.Fqn;
import org.jdiameter.api.slh.ClientSLhSession;
import org.jdiameter.client.api.IContainer;
import org.jdiameter.client.impl.app.slh.IClientSLhSessionData;
import org.jdiameter.common.api.app.slh.SLhSessionState;
import org.mobicents.cluster.MobicentsCluster;
import org.mobicents.diameter.impl.ha.common.slh.SLhSessionDataReplicatedImpl;
import org.mobicents.diameter.impl.ha.data.ReplicatedSessionDatasource;

/**
 *
 * @author Fernando Mendioroz (fernando.mendioroz@telestax.com)
 *
 */
public class ClientSLhSessionDataReplicatedImpl extends SLhSessionDataReplicatedImpl implements IClientSLhSessionData {

  /**
   * @param nodeFqn
   * @param mobicentsCluster
   * @param iface
   */
  public ClientSLhSessionDataReplicatedImpl(Fqn<?> nodeFqn, MobicentsCluster mobicentsCluster, IContainer container) {
    super(nodeFqn, mobicentsCluster, container);

    if (super.create()) {
      setAppSessionIface(this, ClientSLhSession.class);
      setSLhSessionState(SLhSessionState.IDLE);
    }
  }

  /**
   * @param sessionId
   * @param mobicentsCluster
   * @param iface
   */
  public ClientSLhSessionDataReplicatedImpl(String sessionId, MobicentsCluster mobicentsCluster, IContainer container) {
    this(Fqn.fromRelativeElements(ReplicatedSessionDatasource.SESSIONS_FQN, sessionId), mobicentsCluster, container);
  }

}