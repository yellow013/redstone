package io.cygnus.restful.service.resources.executor;

import java.util.ArrayList;
import java.util.List;

import io.cygnus.repository.service.StrategyService;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import io.cygnus.repository.entity.StrategyEntity;
import io.mercury.common.concurrent.cache.CacheList;
import io.mercury.common.concurrent.cache.CacheMap;
import io.mercury.common.log.CommonLoggerFactory;

import javax.annotation.Resource;

@Component
public class StrategyExecutor {

	private static final Logger log = CommonLoggerFactory.getLogger(StrategyExecutor.class);

	@Resource
	private StrategyService strategyService;

	/**
	 * All strategy Cache
	 */
	private final CacheList<StrategyEntity> strategyCacheList = new CacheList<>(() -> {
		return null;
	});

	/**
	 * 
	 * @return
	 */
	public List<StrategyEntity> getAllStrategy() {
		return strategyCacheList.get();
	}

	/**
	 * Strategy CacheMap
	 */
	private final CacheMap<Integer, StrategyEntity> StrategyCacheMap = CacheMap.newBuilder().buildWith((strategyId) -> {
		return strategyService.getStrategyById(strategyId);
	});

	/**
	 * 
	 * @param strategyId
	 * @return
	 */
	public StrategyEntity getStrategyById(Integer strategyId) {
		return StrategyCacheMap.getOptional(strategyId).get();
	}

	/**
	 * StrategyDefaultParam Cache
	 */
	private static final CacheList<StrategyDefaultParam> AllStrategyDefaultParamCache = new CacheList<>(() -> {
		return strategyDao.getAllDefaultParam();
	});

	/**
	 * StrategyParam CacheMap
	 */
	private static final CacheMap<Integer, List<StrategyParam>> StrategyParamCacheMap = CacheMap.newBuilder()
			.buildWith((strategyId) -> {
				List<StrategyParam> strategyParams = strategyDao.getParamsByStrategyId(strategyId);
				List<StrategyParam> mergeList = new ArrayList<>(strategyParams);
				// 遍历全部默认参数
				for (StrategyDefaultParam defaultParam : AllStrategyDefaultParamCache.get()) {
					boolean existed = false;
					for (StrategyParam strategyParam : strategyParams) {
						// 判断策略参数与默认参数是否相同
						if (strategyParam.isSame(defaultParam)) {
							// 如果相同, 则使用策略参数
							existed = true;
							break;
						}
					}
					// 如果默认参数在策略参数中不存在, 则将此默认参数添加到策略参数中
					if (!existed) {
						mergeList.add(
								new StrategyParam().setValues4DefaultParam(defaultParam).setStrategyId(strategyId));
					}
				}
				return mergeList;
			});

	/**
	 * 
	 * @param strategyId
	 * @return
	 */
	public List<StrategyParam> getParamsByStrategyId(Integer strategyId) {
		return StrategyParamCacheMap.getOptional(strategyId).get();
	}

	/**
	 * 
	 * @param strategyParam
	 * @return
	 */
	public boolean putStrategyParam(StrategyParam strategyParam) {
		boolean isSuccess = strategyDao.putStrategyParam(strategyParam);
		if (isSuccess) {
			StrategyParamCacheMap.setUnavailable(strategyParam.getStrategyId());
			return true;
		} else {
			return false;
		}
	}

	/**
	 * StrategySymbol CacheMap
	 */
	private static CacheMap<Integer, List<StrategySymbol>> strategySymbolCacheMap = CacheMap.newBuilder()
			.buildWith((strategyId) -> {
				return strategyDao.getSymbolsByStrategyId(strategyId);
			});

	public List<StrategySymbol> getSymbolsByStrategyId(Integer strategyId) {
		return strategySymbolCacheMap.getOptional(strategyId).get();
	}

}
